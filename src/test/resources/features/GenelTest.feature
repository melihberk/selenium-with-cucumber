Feature: Trendyol Genel Test

  @Smoke
  Scenario: Üye Girişi Yapılmadan Sepette Ürün Yönetimi

    Given Kullanıcı ana sayfaya gider ve çerezleri kabul eder
    When Searchbox'a "Tommy" yazılıp enter tuşuna basılır
    Then URL "sr?q=Tommy" içermelidir
    And Kategorilerden "El Çantası" filtresi seçilir
    And Yüksek puanlı ürünler filtresi tıklanır
    And Listelenen ürünlerden rastgele biri seçilir
    And Konum seç bilgilendirme mesajı kapatılır
    Then "ürün başlığı" elementi görünür olmalıdır
    And "Sepete Ekle Butonu" elementi görünür olmalıdır
    And Sepete ekle butonuna tıklanır
    And Sepete gidilir
    Then "Sepeti Onayla butonu" elementi görünür olmalıdır
    And Sil butonuna tıklanarak sepet temizlenir
    Then Ürünün sepetten kaldırıldığı mesajı görünür olmalıdır
