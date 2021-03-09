module com.kumar {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires transitive javafx.graphics;
    
    opens com.kumar;
    opens com.kumar.controller;
    
    exports com.kumar;
    exports com.kumar.controller;
}