package org.apache.cayenne;

import javafx.fxml.FXMLLoader;

import java.net.URL;

public interface FXMLLoaderFactory {

    FXMLLoader getLoader(URL resourceUrl);
}
