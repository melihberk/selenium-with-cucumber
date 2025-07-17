Feature: Genel Test Excel Kullanımı

  @Smoke
Scenario: Üye Girişi Yapılmadan Sepette Ürün Yönetimi - Excel Kullanımı

Given Kullanıcı ana sayfaya gider ve çerezleri kabul eder
When Excel dosyasından alınan kelime Searchbox'a yazılır ve enter tuşuna basılır
And Kategorilerden "El Çantası" filtresi seçilir
And Yüksek puanlı ürünler filtresi tıklanır
And Listelenen ürünlerden rastgele biri seçilir
And Konum seç bilgilendirme mesajı kapatılır
Then "Ürün Başlığı" elementi görünür olmalıdır
And "Sepete Ekle Butonu" elementi görünür olmalıdır
And Sepete ekle butonuna tıklanır
And Sepete gidilir
Then "Sepeti Onayla butonu" elementi görünür olmalıdır
And Sil butonuna tıklanarak sepet temizlenir
Then Ürünün sepetten kaldırıldığı mesajı görünür olmalıdır