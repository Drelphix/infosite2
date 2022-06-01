package by.infosite.model.information.column;

public enum ColType {
    TEXT, //standard text format of cells
    PASSWORD, //text format of cells hidden when displayed
    LINK, //Displayed as a link, shortened display
    PICTURE, //Image display
    FILE, //Downloading a file when clicked
    UNIQUE, //All cells in the column are unique
    VERSIONING //Allow save and look all changes of column
}
