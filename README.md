<p align="center">
    <img src="https://applitools.com/wp-content/uploads/2020/08/Selenium_Hex-1.svg" width="50">
  &nbsp;&nbsp;&nbsp;
 <img src="https://www.kariyerimdergisi.com/wp-content/uploads/2021/01/Trendyol-logo.jpg" width="75">
  &nbsp;&nbsp;&nbsp;
</p>

<p align="center">

  <img src="https://img.shields.io/badge/Cucumber-BDD-23d160?style=flat-square&logo=cucumber" />
  <img src="https://img.shields.io/badge/Allure-Report-orange?logo=allure" />
  <img src="https://img.shields.io/badge/JUnit-4.13.2-blue?logo=junit5" />
  <img src="https://img.shields.io/badge/Apache POI-Excel-green?logo=apache" />
</p>

<h1 align="center">🧪 Trendyol Web UI Otomasyon Projesi</h1>


## 📂 İçindekiler

- [📘 Proje Açıklaması](#-proje-açıklaması)
- [🚀 Kullanılan Teknolojiler](#-kullanılan-teknolojiler)
- [📁 Proje Yapısı](#-proje-yapısı)
- [📁 Test Senaryolari](#-test-senaryolari)
- [📊 Raporlama – Allure Reporter](#-raporlama--allure-reporter)
- [⚙️ CI/CD – GitHub Actions ile Entegrasyon](#-cicd--github-actions-ile-entegrasyon)
- [🙏 Teşekkürler](#-teşekkürler)



## 📘 Proje Açıklaması

Bu proje, **Trendyol Web arayüzü** üzerinde uçtan uca testlerin otomasyonunu sağlamak amacıyla oluşturulmuştur.  
Modern test mühendisliği yaklaşımlarından biri olan **BDD (Behavior Driven Development)** yaklaşımı kullanılmıştır.
Kullanılan test mimarisi içerisinde:
* ✅ Selenium WebDriver ile web etkileşimleri gerçekleştirilmekte,
* ✅ Cucumber ile senaryolar doğal dilde tanımlanmakta,
* ✅ JUnit ile testlerin entegrasyonu sağlanmakta,
* ✅ Allure Reporter ile detaylı test çıktıları görsel olarak sunulmakta,
* ✅ GitHub Actions ile CI/CD entegrasyonu üzerinden testler otomatik olarak tetiklenmektedir.



## 🚀 Kullanılan Teknolojiler

| Teknoloji | Versiyon | Açıklama |
|----------|----------|----------|
| Java     | 17       | Test dili |
| Maven    | 3.9+     | Build aracı |
| Selenium | 4.16.1   | WebDriver |
| Cucumber | 7.x      | BDD Framework |
| JUnit    | 4.x      | Test runner |
| Allure   | 2.x      | HTML test raporları |
| GitHub Actions | CI/CD | Otomatik test süreçleri |


## 📁 Proje Yapısı

```bash
selenium-bdd-project
├── .idea/                            # IntelliJ IDEA ayarları
├── logs/                             # Log dosyalarının tutulduğu klasör
├── pom.xml                           # Maven bağımlılık yönetim dosyası
├── README.md                         # Projeye dair genel dokümantasyon
├── bddframework.iml                  # IntelliJ IDEA module dosyası
├── .gitignore                        # Versiyon kontrolünde yok sayılacak dosyalar
├── target/                           # Maven build çıktısı (raporlar, class dosyaları vb.)

├── Selenium Java BDD [bddframework]/
│   └── .github/
│       └── workflows/
│           └── test.yml             # GitHub Actions CI/CD pipeline tanımı (Allure, Maven)

├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       │   └── DriverFactory.java       # WebDriver oluşturma, config okuma
│   │       ├── pages/
│   │       │   ├── BasketPage.java          # Sepet sayfası aksiyonları
│   │       │   ├── HomePage.java            # Ana sayfa aksiyonları
│   │       │   ├── ProductPage.java         # Ürün detay sayfası işlemleri
│   │       │   └── SearchResultsPage.java   # Arama sonuçları ile ilgili işlemler
│   │       └── utils/
│   │           ├── Assertions.java          # Assertion yardımcı metotları
│   │           ├── ConfigReader.java        # config.properties okuma aracı
│   │           ├── ElementUtils.java        # Click, scroll, isVisible gibi element işlemleri
│   │           ├── ExcelUtils.java          # Apache POI ile excel veri okuma
│   │           ├── WaitUtils.java           # WebDriverWait işlemleri
│   │           └── elementStore/
│   │               └── (locator'lar burada)  # Sayfalara göre ayrılmış static By tanımları

│   ├── test/
│   │   └── java/
│   │       ├── hooks/
│   │       │   └── Hooks.java                # Cucumber Before/After metotları
│   │       ├── pages/                        # (isteğe bağlı tekrar tanımlamalar)
│   │       ├── runners/
│   │       │   └── TestRunner.java           # JUnit Runner
│   │       ├── stepDefinitions/
│   │       │   ├── AssertSteps.java
│   │       │   ├── BasketSteps.java
│   │       │   ├── HomeSteps.java
│   │       │   ├── ProductSteps.java
│   │       │   └── SearchSteps.java          # Gherkin adımlarına karşılık gelen Java sınıfları
│   │       └── utils/                        # (isteğe bağlı test-side yardımcılar)

│   └── resources/
│       ├── features/
│       │   └── GenelTest.feature             # Test senaryoları (BDD)
│       ├── config.properties                 # Tarayıcı, timeout vb. konfigürasyonlar
│       ├── data.xlsx                         # Arama verisi gibi test datası
│       └── logback.xml                       # Log yapılandırma dosyası
```
### 📁 Geliştirme Notları
* Proje Page Object Model (POM) mimarisi ile yapılandırılmıştır; sayfa aksiyonları pages/, locator'lar elementStore/ klasöründe tutulur.
* utils/ klasöründe yer alan WaitUtils, ElementUtils, ExcelUtils, Assertions gibi yardımcı sınıflar ile tekrar eden işlemler merkezi hâle getirilmiştir.
* config.properties dosyası üzerinden browser seçimi, ekran çözünürlüğü, timeout gibi ayarlar yönetilebilir.
* Test verileri data.xlsx dosyasından dinamik olarak okunur.
* Cucumber senaryoları @tag yapısı ile gruplanabilir, bu sayede belirli senaryolar komut satırından ayrı olarak çalıştırılabilir.
* Test runner olarak JUnit kullanılmakta olup, TestRunner.java üzerinden feature dosyalarının konumu, glue path ve raporlama ayarları yapılandırılmıştır.
* CI/CD süreci için .github/workflows/test.yml dosyası içinde GitHub Actions pipeline tanımı yer alır. Her push'ta testler çalıştırılır ve Allure raporu otomatik oluşturulur.
* Her adım sonrası ekran görüntüsü alınacak şekilde yapılandırma yapılmıştır (başarılı veya başarısız fark etmeksizin).


---

## 📁 Test Senaryolari
Bu senaryo, üye girişi yapılmadan bir ürünün aratılması, filtrelenmesi, sepete eklenmesi ve sepetten kaldırılması adımlarını kapsamaktadır.
Amaç, ziyaretçi olarak ürün yönetimi işlemlerinin başarıyla gerçekleştirilebildiğini test etmektir.

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



## 📊 Raporlama – Allure Reporter

Bu projede, Allure Reporter ile test sonuçları detaylı ve görsel olarak analiz edilebilmektedir. Her bir test adımı; süresi, başarılı/başarısız durumu, ekran görüntüsü (screenshot) ve hata detaylarıyla birlikte sunulur.

### ⚙️ Allure Konfigürasyonu

* allure-cucumber7-jvm bağımlılığı pom.xml içerisinde tanımlanmıştır.
* maven-surefire-plugin ile testlerin çıktısı target/allure-results/ klasörüne otomatik olarak yazılır.
* Testler sırasında başarısız olan adımlarda otomatik olarak ekran görüntüsü alınır ve Allure raporuna eklenir.
* Allure HTML raporu, GitHub Actions üzerinden otomatik üretilir ve Allure HTML Report adıyla dışa aktarılır.

### 📂 Raporların Konumu
| Klasör                  | Açıklama                                          |
| ----------------------- | ------------------------------------------------- |
| `target/allure-results` | Test çalıştırmalarından sonra oluşan ham sonuçlar |
| `target/allure-report`  | HTML bazlı interaktif test raporu                 |


### 🖼️ Allure Rapor Örneği

Aşağıda projemizin Allure test raporu ekran görüntüsü yer almaktadır:

[![Image](https://i.hizliresim.com/1bw80co.png)](https://hizliresim.com/1bw80co)


> Rapor sayesinde her test adımını, sürelerini, hata mesajlarını ve ekran görüntülerini kolayca analiz edebilirsiniz.

---

## ⚙️ CI/CD – GitHub Actions ile Entegrasyon
📁 .github/workflows/test.yml

> Projede test senaryoları her main branch’e yapılan push işleminde CI/CD pipeline üzerinden otomatik olarak çalıştırılır.
Bu işlem; testlerin doğruluğunu, sistem entegrasyonunu ve raporlamayı güvence altına alır.

| Aşama                       | Açıklama                                |
| --------------------------- | --------------------------------------- |
| 🛠 `checkout`               | Repo'yu çek                             |
| ☕️ `setup-java`             | Java 17 kurulumu                        |
| 🌐 `echo browser=firefox`   | Test tarayıcısını override eder         |
| 🔍 `mvn clean test`         | Maven üzerinden testleri çalıştırır     |
| 📈 `allure generate`        | Test sonuçlarından Allure raporu üretir |
| 🧳 `upload-artifact`        | Allure sonuçlarını ve raporları saklar  |
| 🌍 `deploy to GitHub Pages` | Raporları GitHub Pages'e deploy eder    |

###🚀 Neden Allure + GitHub Actions?

✅ Her test çalışmasında otomatik ve interaktif test raporları oluşturur

✅ Başarısız adımlarda ekran görüntüsü ile hata teşhisi kolaylaşır

✅ Takım içi şeffaflık ve test kalitesinde güven sağlar

✅ Hiçbir IDE veya ek kurulum gerekmeden GitHub üzerinden erişilebilir



## 🙏 Teşekkürler



<br/>




