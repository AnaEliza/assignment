package com.github.anaeliza.dragonsofmugloar.services;

import java.io.InputStream;
import java.util.stream.IntStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.anaeliza.dragonsofmugloar.domain.Weather;

public class WeatherService extends Service {
    
    private static final String WEATHER_SERVICE_URL = "weather/api/report/";
    private static final String WEATHER_NODE = "code";
    
    public Weather getWeatherForecast(int gameId) {
        try {
            InputStream is = get(WEATHER_SERVICE_URL + gameId);
            Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            NodeList nodes = xml.getDocumentElement().getChildNodes();
            
            Node node = IntStream
                    .range(0, nodes.getLength())
                    .mapToObj(nodes::item)
                    .filter(n -> n.getNodeName().equals(WEATHER_NODE))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("Can't find weather code for gameId " + gameId));
            
            return Weather.getByCode(node.getTextContent());
        } catch (Exception e) {
            throw new RuntimeException("Error while trying to get the weather forecast for gameId " + gameId, e);
        }
    }
    
}
