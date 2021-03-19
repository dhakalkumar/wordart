module com.kumar {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires transitive javafx.graphics;
	requires javafx.swing;
    
    opens com.kumar;
    opens com.kumar.controller;
    
    exports com.kumar;
    exports com.kumar.controller;
}