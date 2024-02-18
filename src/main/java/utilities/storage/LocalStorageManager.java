package utilities.storage;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import utilities.web.DriverManager;


public class LocalStorageManager {

    public static LocalStorage createLocalStorage(String itemKey, String itemValue){
        WebStorage webStorage = (WebStorage) new Augmenter().augment(DriverManager.getDriver());
        LocalStorage localStorage = webStorage.getLocalStorage();
        localStorage.setItem(itemKey, itemValue);
        return localStorage;
    }
    public static LocalStorage createLocalStorage(String item1Key, String item1Value, String item2Key, String item2Value){
        WebStorage webStorage = (WebStorage) new Augmenter().augment(DriverManager.getDriver());
        LocalStorage localStorage = webStorage.getLocalStorage();
        localStorage.setItem(item1Key, item1Value);
        localStorage.setItem(item2Key, item2Value);
        return localStorage;
    }
}
