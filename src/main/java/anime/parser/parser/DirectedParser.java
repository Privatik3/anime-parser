package anime.parser.parser;

import java.io.IOException;

public interface DirectedParser {

    public String getDirectedNameById(int directedId) throws IOException, Exception;
    public String getDirectedResourcesById(int directedId) throws IOException, Exception;
}