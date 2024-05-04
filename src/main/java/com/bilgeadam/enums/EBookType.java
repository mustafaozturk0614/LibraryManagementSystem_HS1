package com.bilgeadam.enums;

public enum EBookType {
    NOVEL("Roman"),
FICTION("Kurgu"),
NONFICTION("Gerçek"),
SCIENCE_FICTION("Bilim Kurgu"),
FANTASY("Fantazi"),
MYSTERY("Gizem"),
THRILLER("Gerilim"),
ROMANCE("Aşk"),
HORROR("Korku"),
BIOGRAPHY("Biyografi"),
HISTORY("Tarih"),
SCIENCE("Bilim"),
POETRY("Şiir"),
GRAPHIC_NOVEL("Grafik Roman"),
COMIC_BOOK("Çizgi Roman"),
COOKBOOK("Yemek Kitabı"),
DIARY("Günlük"),
JOURNAL("Dergi"),
TRAVEL("Seyahat"),
HEALTH("Sağlık"),
RELIGION("Din"),
TEXTBOOK("Ders Kitabı"),
REFERENCE("Kaynak"),
ART("Sanat"),

    DETECTIVE("Polisiye");
    
    private String description;

    EBookType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
