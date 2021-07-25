package com.tl.other.work;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ZoneInfo {

    private static List<ZoneConfig> zoneConfigs = new ArrayList<>();
    static{
        zoneConfigs.add(new ZoneConfig("阿尔岛" , "192.168.1.5" , 8000 ,20, 300));
        zoneConfigs.add(new ZoneConfig("可可岛" , "192.168.1.5" , 8000 ,60, 400));
        zoneConfigs.add(new ZoneConfig("奥比岛" , "192.168.1.5" , 8000 ,90, 300));
        zoneConfigs.add(new ZoneConfig("波比岛" , "192.168.1.6" , 8000 ,60, 300));
        zoneConfigs.add(new ZoneConfig("奥拉岛" , "192.168.1.6" , 8000 ,70, 300));
        zoneConfigs.add(new ZoneConfig("奥奇岛" , "93.63.1.100" , 8003 ,50, 300));
        zoneConfigs.add(new ZoneConfig("奥雅岛" , "95.68.31.115" , 8001 ,180, 300));
//        zoneConfigs.add(new ZoneConfig("$test" , "95.68.31.115" , 8003 ,1, 300));
    }

    private static List<ZoneMapping> zoneMappings = new ArrayList<>();

    static{
        zoneMappings.add(new ZoneMapping("192.168.1.5", "socket1.bt.com" , true));
        zoneMappings.add(new ZoneMapping("192.168.1.6", "socket2.bt.com" , false));
    }

    private static final String TAP = "\\u0020";

    //转xml
    public static String toXMLString(List<ZoneConfig> zoneConfigs , List<ZoneMapping> zoneMappings ){
        HashMap<String, String> zoneMapper = new HashMap<>();
        zoneMappings.stream()
                .filter(zoneMapping -> zoneMapping.canUse)
                .forEach(zoneMapping -> {
            zoneMapper.putIfAbsent(zoneMapping.getIp() , zoneMapping.getDomain());
        });
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            // 设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
            // document.setXmlStandalone(true);
            Element root = document.createElement("root");
            Element servers = document.createElement("servers");
            Element zones = document.createElement("zones");

            for (int i = 0,  serverIndex =0 ; i < zoneConfigs.size(); i++) {
                ZoneConfig zoneConfig = zoneConfigs.get(i);
                if( i== 0 || !zoneConfigs.get(i-1).equals(zoneConfigs.get(i))){ //保证zoneConfigs有序
                    final String domain = zoneConfig.getIp() + "/" + zoneConfig.getPort();
                    Element server = document.createElement("server");
                    server.setTextContent(zoneMapper.getOrDefault(zoneConfig.getIp() , domain));
                    servers.appendChild(server);
                    serverIndex++;
                }
                final String name = zoneConfig.getzoneName();
                final Integer capacity = culCapacity(zoneConfig.getCurrent_online_member(), zoneConfig.getMax_online_member());
                Element zone = document.createElement("zone");
                zone.setAttribute("name", name);
                zone.setAttribute("serverIndex", String.valueOf(serverIndex));
                zone.setAttribute("capacity", capacity.toString());
                zones.appendChild(zone);
            }
            root.appendChild(servers);
            root.appendChild(zones);
            document.appendChild(root);
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            StringWriter writer = new StringWriter();
            tf.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Integer culCapacity(int curr_member , int max_member){
        float proportion = (float) curr_member/max_member;
        if(proportion >=0.8f){
            return 7;
        }else if(proportion>= 0.7f){
            return 6;
        }else if(proportion>= 0.5f){
            return 5;
        }else if(proportion>= 0.4f){
            return 4;
        }else if(proportion>= 0.3f){
            return 3;
        }else if(proportion>= 0.1f){
            return 2;
        }else if(proportion>= 0.0f){
            return 1;
        }
        return -1;
    }
    private  static class ZoneConfig{
        private String zoneName;
        private String ip ;
        private int port;
        private int current_online_member;
        private  int max_online_member;

        public ZoneConfig(String zoneName, String ip, int port, int current_online_member, int max_online_member) {
            this.zoneName = zoneName;
            this.ip = ip;
            this.port = port;
            this.current_online_member = current_online_member;
            this.max_online_member = max_online_member;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getzoneName() {
            return zoneName;
        }

        public String getIp() {
            return ip;
        }

        public int getPort() {
            return port;
        }

        public int getCurrent_online_member() {
            return current_online_member;
        }

        public int getMax_online_member() {
            return max_online_member;
        }

        @Override
        public int hashCode() {
            final String domain = this.getIp() + "" +this.getPort();
            return domain.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ZoneConfig zoneConfig = (ZoneConfig) obj;
            if(zoneConfig.getIp() == null || !zoneConfig.getIp().equals(this.getIp())){
                return false;
            }
            if(zoneConfig.getPort() != this.getPort()){
                return false;
            }
            return true;
        }
    }

    private static class ZoneMapping{
        private  String ip ;
        private  String domain ;
        private  boolean canUse ;

        public ZoneMapping(String ip, String domain, boolean canUse) {
            this.ip = ip;
            this.domain = domain;
            this.canUse = canUse;
        }

        public String getIp() {
            return ip;
        }

        public String getDomain() {
            return domain;
        }

        public boolean isCanUse() {
            return canUse;
        }
    }


    public static void main(String[] args) {
//        System.out.println((float) 6/12 == 0.5f);
        String xmlString = toXMLString(zoneConfigs, zoneMappings);
        System.out.println("toXML: " + xmlString);
    }
}
