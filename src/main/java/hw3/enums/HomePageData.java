package hw3.enums;

import java.util.ArrayList;
import java.util.List;

public enum HomePageData {
    INDEX_HTML_URL("https://epam.github.io/JDI/index.html"),
    HOME_PAGE_TITLE("Home Page"),
    HEADER_SECTION_TITLE_1("HOME"),
    HEADER_SECTION_TITLE_2("CONTACT FORM"),
    HEADER_SECTION_TITLE_3("SERVICE"),
    HEADER_SECTION_TITLE_4("METALS & COLORS"),
    TEXT_UNDER_IMAGE_1("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    TEXT_UNDER_IMAGE_2("To be flexible and\n" + "customizable"),
    TEXT_UNDER_IMAGE_3("To be multiplatform"),
    TEXT_UNDER_IMAGE_4("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n"
            + "wish to get more…"),
    TEXT_HEADER("EPAM FRAMEWORK WISHES…"),
    TEXT_CONTENT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
            "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
            "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR " +
            "IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    TEXT_SUB_HEADER("JDI GITHUB"),
    JDI_GITHUB_LINK("https://github.com/epam/JDI");

    public String value;

    HomePageData(String value) {
        this.value = value;
    }

    // TODO You can split your master-enum in several enums
    // TODO in order to avoid kind of this methods
    public static List<String> getHeaderSectionText() {
        List<String> headerSection = new ArrayList<>();
        headerSection.add(HEADER_SECTION_TITLE_1.value);
        headerSection.add(HEADER_SECTION_TITLE_2.value);
        headerSection.add(HEADER_SECTION_TITLE_3.value);
        headerSection.add(HEADER_SECTION_TITLE_4.value);
        return headerSection;
    }

    public static List<String> getTextsUnderImages() {
        List<String> textsUnderImages = new ArrayList<>();
        textsUnderImages.add(TEXT_UNDER_IMAGE_1.value);
        textsUnderImages.add(TEXT_UNDER_IMAGE_2.value);
        textsUnderImages.add(TEXT_UNDER_IMAGE_3.value);
        textsUnderImages.add(TEXT_UNDER_IMAGE_4.value);
        return textsUnderImages;
    }
    // !TODO

    @Override
    public String toString() {
        return value;
    }
}