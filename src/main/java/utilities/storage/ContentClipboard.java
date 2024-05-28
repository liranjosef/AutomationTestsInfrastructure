package utilities.storage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class ContentClipboard {

    public static void setStringClipboard(String text){

        StringSelection stringSelection = new StringSelection(text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
    }
}
