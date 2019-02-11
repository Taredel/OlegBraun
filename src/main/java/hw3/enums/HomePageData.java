package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum HomePageData {
    INDEX_HTML_URL("https://epam.github.io/JDI/index.html"),
    HOME_PAGE_TITLE("Home Page"),
    TEXT_HEADER("EPAM FRAMEWORK WISHES…"),
    TEXT_CONTENT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
            "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
            "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
            "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    JDI_GITHUB("JDI GITHUB"),
    JDI_GITHUB_LINK("https://github.com/epam/JDI");

    public String value;

    HomePageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}