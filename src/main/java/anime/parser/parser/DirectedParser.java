package anime.parser.parser;

import java.io.IOException;

public interface DirectedParser {

    public String getDirectedNameById(int directedId) throws IOException;
    public String getDirectedResourcesById(int directedId) throws IOException;
}
