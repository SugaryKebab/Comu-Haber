package edu.comu.haber.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParser{
    private Document html;
    private Elements table;

    protected void fetchHtml(String url) throws IOException {
        String a = "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"tr-TR\" prefix=\"og: http://ogp.me/ns#\">\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\n" +
                "<title>Tüm ÇOMÜ Haberleri - Çanakkale Onsekiz Mart Üniversitesi Sayfa - </title> \n" +
                "<base href=\"//www.comu.edu.tr/\" />\n" +
                "<link rel=\"shortcut icon\" href=\"favicon.ico\" />\n" +
                "<link rel=\"search\" type=\"application/opensearchdescription+xml\" title=\"COMU\" href=\"assets/opensearch.xml\"/>\n" +
                "<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n" +
                "<link rel=\"stylesheet\" href=\"assets/css/style.css?v=01\"  type=\"text/css\" >\n" +
                "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n" +
                "    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n" +
                "    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n" +
                "    <![endif]-->\n" +
                "<meta name=\"description\" content=\"Tüm ÇOMÜ Haberleri - Çanakkale Onsekiz Mart Üniversitesi\"/>\n" +
                "<meta name=\"keywords\" content=\"çomü haberleri, çomü, comu, çanakkale, canakkale, onsekiz, mart, onsekiz mart, üniversite, university, onsekiz mart üniversitesi, sanat, topluluk, uluslararası\"/>\n" +
                "<meta name=\"robots\" content=\"index,follow\" /> \n" +
                "<meta name=\"googlebot\" content=\"all\" />\n" +
                "<meta name=\"revisit-after\" content=\"1 Days\" />\n" +
                "<meta name=\"distribution\" content=\"global\" />\n" +
                "<meta name=\"rating\" content=\"general\" />\n" +
                "<meta name=\"author\" content=\"Çanakkale Onsekiz Mart Üniversitesi\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "    <header id=\"navigation\">\n" +
                "        <div class=\"golgeAltsayfa\"></div>\n" +
                "<div class=\"user-top\">\n" +
                "    <div id=\"navmenu\"></div>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"slogan visible-lg\"><strong>ÇOMÜ - </strong>Eğitimde ve Bilimde Dünya Üniversitesi</div>\n" +
                "        <div class=\"ust_linkler top10\"> \n" +
                "            <ul>\n" +
                "                <li><a href=\"https://ubys.comu.edu.tr\" target=\"_blank\" title=\"Üniversite Bilgi Yönetim Sistemi\">UBYS</a></li>\n" +
                "                <li><a href=\"https://global.comu.edu.tr\" title=\"English\">English</a></li>\n" +
                "                <li><a href=\"/ulasim\" title=\"Ulaşım\">Ulaşım</a></li>\n" +
                "            </ul>\n" +
                "        </div>  \n" +
                "    </div>\n" +
                "</div>        <div role=\"banner\" class=\"navbar menuArka\">\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"navbar-header\">\n" +
                "            <button data-target=\".navbar-collapse\" data-toggle=\"collapse\" class=\"navbar-toggle\" type=\"button\">\n" +
                "                <span class=\"sr-only\">Toggle navigation</span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "            </button>\n" +
                "            <a href=\"//www.comu.edu.tr\" class=\"navbar-brand\">\n" +
                "                <img alt=\"\" src=\"assets/img/comu-logo.png\" class=\"main-logo logo-fix\" />\n" +
                "                <img alt=\"\" src=\"assets/img/logo-kucuk.png\" class=\"logo-two img-responsive\" />\n" +
                "            </a> \n" +
                "        </div>\n" +
                "        <div class=\"top-bar\">\n" +
                "            <ul class=\"list-inline social-icons\">\n" +
                "                <li><a target=\"_blank\" href=\"https://www.facebook.com/onsekizmartuni\"><i class=\"fab fa-facebook-square\"></i></a></li>\n" +
                "                <li><a target=\"_blank\" href=\"https://twitter.com/onsekizmartuni\"><i class=\"fab fa-twitter-square\"></i></a></li>\n" +
                "                <li><a target=\"_blank\" href=\"https://plus.google.com/114922856483406230073/posts\"><i class=\"fab fa-google-plus-square\"></i></a></li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        <nav class=\"collapse navbar-collapse navbar-right\" id=\"main-menu\">\n" +
                "            <ul class=\"nav navbar-nav\">\n" +
                "                <li><a href=\"//www.comu.edu.tr\"><i class=\"fas fa-home\"></i>  Ana Sayfa</a></li>\n" +
                "                <li class=\"dropdown \">\n" +
                "                    <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"javascript:void(0);\">Genel Bilgiler <i class=\"fas fa-angle-down\"></i></a>\n" +
                "                    <ul class=\"dropdown-menu drop_setting\">\n" +
                "                        <!-- <li><a tabindex=\"-1\" href=\"/rektorun-mesaji\"> Rektörün Mesajı </a></li>-->\n" +
                "                        <li><a tabindex=\"-1\" href=\"/misyon-vizyon\"> Misyon ve Vizyon </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/tarihce\"> Tarihçe </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/yerleskeler\"> Yerleşkeler </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://album.comu.edu.tr\" target=\"_blank\"> Fotoğraflarla ÇOMÜ </a></li>\n" +
                "                        <!-- <li><a tabindex=\"-1\" href=\"//www.comu.edu.tr/tanitim/video/\"> Videolarla ÇOMÜ </a></li>-->\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://tercihim.comu.edu.tr\" target=\"_blank\"> Tercihim ÇOMÜ !</a></li>\n" +
                "                    </ul>\n" +
                "                </li>\n" +
                "                <li class=\"dropdown active\">\n" +
                "                    <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"javascript:void(0);\">Öğrenci <i class=\"fas fa-angle-down\"></i></a>\n" +
                "                    <ul class=\"dropdown-menu drop_setting\">\n" +
                "                        <!--  <li><a tabindex=\"-1\" href=\"//www.comu.edu.tr/ogrencibilgi/\" target=\"_blank\"> Öğrenciler İçin </a></li> -->\n" +
                "                        <li><a tabindex=\"-1\" href=\"https://ubys.comu.edu.tr/\" target=\"_blank\"> UBYS - Öğrenci Bilgi Sistemi Modülü</a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://ogrenciisleri.comu.edu.tr/akademiktakvim\" target=\"_blank\"> Akademik Takvim </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://ogrenciisleri.comu.edu.tr\" target=\"_blank\"> Öğrenci İşleri Daire Başkanlığı </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://omik.comu.edu.tr\" target=\"_blank\"> Öğrenci Yaşam ve Kariyer Merkezi </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://otk.comu.edu.tr\" target=\"_blank\"> Öğrenci Temsilciler Konseyi </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://sks.comu.edu.tr\" target=\"_blank\"> Öğrenci Toplulukları </a></li>\n" +
                "                       <!-- <li><a tabindex=\"-1\" href=\"//kagem.comu.edu.tr\" target=\"_blank\"> Kariyer Gelişim Merkezi </a></li> -->\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://gdb.comu.edu.tr/index\" target=\"_blank\"> Gençlik Danışma Merkezi </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://ekb.comu.edu.tr\" target=\"_blank\"> Engelsiz ÇOMÜ Öğrenci Birimi </a></li>\n" +
                "                 \n" +
                "                    </ul>\n" +
                "                </li>\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"javascript:void(0);\">Akademik <i class=\"fas fa-angle-down\"></i></a>\n" +
                "                    <ul class=\"dropdown-menu drop_setting\">\n" +
                "                        <li><a tabindex=\"-1\" href=\"/enstituler\"> Enstitüler </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/fakulteler\"> Fakülteler </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/yuksekokullar\"> Yüksekokullar </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/meslek-yuksekokullari\"> Meslek Yüksekokulları </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/rektorluge-bagli-bolumler\"> Rektörlüğe Bağlı Bölümler </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/arastirma-merkezleri\"> Araştırma Merkezleri </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://arastirma.comu.edu.tr\" target=\"_blank\"> Bilimsel Araştırma Projeleri </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://hastane.comu.edu.tr\" target=\"_blank\"> Uygulama ve Araştırma Hastanesi </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/koordinatorlukler\"> Koordinatörlükler </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/kurullar\"> Kurullar </a></li>\n" +
                "                    </ul>\n" +
                "                </li>\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"javascript:void(0);\">İdari <i class=\"fas fa-angle-down\"></i></a>\n" +
                "                    <ul class=\"dropdown-menu drop_setting\">\n" +
                "                        <li><a tabindex=\"-1\" href=\"/rektorluk\"> Rektörlük </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/senato\"> Senato </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/yonetim-kurulu\"> Yönetim Kurulu </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/ozel-kalem\"> Özel Kalem </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://genelsekreterlik.comu.edu.tr\" target=\"_blank\"> Genel Sekreterlik </a></li>             \n" +
                "                        <li><a tabindex=\"-1\" href=\"/idari-birimler\"> İdari Birimler </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/basin\">Basın Yayın ve Halkla İlişkiler </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://dsi.comu.edu.tr\" target=\"_blank\"> Döner Sermaye </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"/yonetmelikler\"> Yönetmelik ve Yönergeler </a></li>\n" +
                "                        <!-- <li><a tabindex=\"-1\" href=\"#\"> Kararlar </a></li> -->\n" +
                "                    </ul>\n" +
                "                </li>\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"javascript:void(0);\">Servisler <i class=\"fas fa-angle-down\"></i></a>\n" +
                "                    <ul class=\"dropdown-menu drop_setting\">\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://lib.comu.edu.tr\" target=\"_blank\"> Kütüphane </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://comukart.comu.edu.tr\" target=\"_blank\"> ÇOMÜKart </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://beb.comu.edu.tr/index\" target=\"_blank\"> Bilgi Edinme Bürosu </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://unigazete.comu.edu.tr\" target=\"_blank\"> Basında ÇOMÜ </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://eposta.comu.edu.tr\" target=\"_blank\"> Çomü E-Posta </a></li>\n" +
                "                        <li><a tabindex=\"-1\" href=\"http://members.comu.edu.tr\" target=\"_blank\"> Kişisel WEB Sayfaları </a></li>\n" +
                "                    </ul>\n" +
                "                </li>\n" +
                "                <li><a href=\"/iletisim\">İletişim <i class=\"fas fa-phone-volume\"></i></a></li>\n" +
                "            </ul>\n" +
                "        </nav>\n" +
                "    </div>\n" +
                "</div>    </header>\n" +
                "    <div class=\"altsayfaBg\"></div>\n" +
                "    <div class=\"altsayfaBaslikAlani\">\n" +
                "        <div class=\"container\">\n" +
                "            <div class=\"col-md-3 col-sm-4 col-xs-12 kirmiziBg\">\n" +
                "                <div class=\"altsayfaKategori\">\n" +
                "                    <h2>\n" +
                "                        HABERLER\n" +
                "                    </h2>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"col-md-9 col-sm-8 col-xs-12\">\n" +
                "                <div class=\"altsayfaBaslik\">\n" +
                "                    <p>Tüm ÇOMÜ Haberleri</p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"wrapper\">\n" +
                "        <div class=\"container\">\n" +
                "            <div class=\"comu-main-alt\">\n" +
                "                <div class=\"col-md-3 col-sm-3 col-xs-12 h_menu margint20\">\n" +
                "    <div class=\"nav-side-menu\">\n" +
                "        <div class=\"brand\"><i class=\"fas fa-bars\"></i> Hızlı Menü</div>\n" +
                "        <i class=\"fas fa-bars fa-2x toggle-btn\" data-toggle=\"collapse\" data-target=\"#menu-content\"></i>\n" +
                "        <div class=\"menu-list\">\n" +
                "            <ul id=\"menu-content\" class=\"menu-content collapse out\">\n" +
                "                <li>\n" +
                "                    <a href=\"/rektorluk-gundem\" target=\"_blank\" class=\"list-group-item stil1\">\n" +
                "                        <span class=\"glyphicon glyphicon-asterisk\" aria-hidden=\"true\"></span> Rektörlük Gündem\n" +
                "                                            </a>\n" +
                "                </li>\n" +
                "\t\t\t\t\n" +
                "                <li>\n" +
                "                    <a href=\"http://kalite.comu.edu.tr/\" class=\"list-group-item\" target=\"_blank\"><span class=\"glyphicon glyphicon-bookmark\" aria-hidden=\"true\"></span> Kalite  </a>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <a href=\"/yayinlarimiz\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-paperclip\" aria-hidden=\"true\"></span> Yayınlarımız </a>\n" +
                "                </li>\n" +
                "                \n" +
                "                 <li>\n" +
                "                    <a href=\"http://oyp.comu.edu.tr\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-education\" aria-hidden=\"true\"></span> ÖYP/Burs Koordinatörlüğü <span class=\"yenispan\">Yeni</span></a>\n" +
                "                </li>\n" +
                "                \n" +
                "                <li>\n" +
                "                    <a href=\"http://sem.comu.edu.tr/arsiv/duyurular\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-grain\" aria-hidden=\"true\"></span> ÇOMÜSEM (Kurslar) </a>\n" +
                "                </li>\n" +
                "                \n" +
                "                <li>\n" +
                "                \n" +
                "                    <a href=\"//hesap.comu.edu.tr\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-send\" aria-hidden=\"true\"></span> ÇOMÜ Tek Hesap </a>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <a href=\"http://ogrenciisleri.comu.edu.tr/akademiktakvim\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-education\" aria-hidden=\"true\"></span> Akademik Takvim</a>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <a href=\"//ubys.comu.edu.tr/\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-blackboard\" aria-hidden=\"true\"></span> Öğrenci Bilgi Sistemi</a>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <a href=\"/etkinlik-takvimi\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-calendar\" aria-hidden=\"true\"></span> Etkinlik Takvimi </a>\n" +
                "                </li> \n" +
                "                <li>\n" +
                "                    <a href=\"http://bidb.comu.edu.tr/programlar/office-365-kayit-kurulumu\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-wrench\" aria-hidden=\"true\"></span> Office Kurulumu <span class=\"yenispan\">Yeni</span></a>\n" +
                "                </li>               \n" +
                "                <li>\n" +
                "                    <a href=\"/faydali-baglantilar\" class=\"list-group-item stil1\"><span class=\"glyphicon glyphicon-send\" aria-hidden=\"true\"></span> Faydalı Bağlantılar</a>\n" +
                "                </li>\n" +
                "                <li>\n" +
                "                    <a href=\"/topluluk-haberleri\" target=\"_blank\" class=\"list-group-item stil1\">\n" +
                "                        <span class=\"glyphicon glyphicon-record\" aria-hidden=\"true\"></span> Topluluk Haberleri\n" +
                "                                                \n" +
                "                    </a>\n" +
                "                </li>\n" +
                "                 <li>\n" +
                "                    <a href=\"http://physics.comu.edu.tr/caam/mainpage.php\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-eye-open\" aria-hidden=\"true\"></span> Gözlem Evi</a>\n" +
                "                </li>\n" +
                "                <li data-toggle=\"collapse\" data-target=\"#kurslar\" class=\"collapsed\">\n" +
                "                    <a href=\"javascript:void(0)\"><i class=\"fas fa-angle-down\"></i> Kurslar</a>\n" +
                "                </li>\n" +
                "                <ul class=\"sub-menu collapse\" id=\"kurslar\">\n" +
                "                    <li><a href=\"http://comudam.comu.edu.tr/\" target=\"_blank\" title=\"ÇOMÜDAM\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> ÇOMÜDAM</a></li>\n" +
                "                    <li><a href=\"http://sem.comu.edu.tr/\" target=\"_blank\" title=\"Sürekli Eğitim Merkezi\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Sürekli Eğitim Merkezi</a></li>\n" +
                "                    <li><a href=\"http://tomer.comu.edu.tr\" target=\"_blank\" title=\"Türkçe ve Yabancı Dil Öğretimi Uyg. ve Araş. Merkezi\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> TÖMER </a></li>\n" +
                "                </ul>\n" +
                "               \n" +
                "               \n" +
                "                <li data-toggle=\"collapse\" data-target=\"#servisler\" class=\"collapsed\">\n" +
                "                    <a href=\"javascript:void(0)\"><i class=\"fas fa-angle-down\"></i> Kütüphane Hizmetleri</a>\n" +
                "                </li>  \n" +
                "                    <ul class=\"sub-menu collapse\" id=\"servisler\">\n" +
                "                        <li><a href=\"http://lib.comu.edu.tr/\" target=\"_blank\" class=\"list-group-item\"><span class=\"glyphicon glyphicon-book\" aria-hidden=\"true\"></span> Kütüphane</a></li>\n" +
                "                        <li><a href=\"http://www.pressreader.com/\" target=\"_blank\" title=\"E-Gazeteler\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> E-Gazeteler (Günlük 7000+)</a></li>\n" +
                "                        <li><a href=\"//search.proquest.com/pqdtglobal/index\" target=\"_blank\" title=\"E-Tezler\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> E-Tezler (4 milyon+)</a></li>\n" +
                "                        <li><a href=\"http://lib.comu.edu.tr/arastirma/veritabanlari-ve-indeksler.html\" target=\"_blank\" title=\"Veri Tabanları & İndeksler\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Veri Tabanları ve İndeksler</a></li>\n" +
                "                        <li><a href=\"http://lib.comu.edu.tr/arastirma/e-kitaplar.html\" target=\"_blank\" title=\"E-Kitaplar\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> E-Kitaplar</a></li>\n" +
                "                        <li><a href=\"//atoz.ebsco.com/search.asp?id=11145\" target=\"_blank\" title=\"E-Dergiler\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> E-Dergiler</a></li>\n" +
                "                    </ul>\n" +
                "\n" +
                "                <li data-toggle=\"collapse\" data-target=\"#uluslararasi\" class=\"collapsed\">\n" +
                "                    <a href=\"javascript:void(0)\"><i class=\"fas fa-angle-down\"></i> Uluslararası</a>\n" +
                "                </li>\n" +
                "                    <ul class=\"sub-menu collapse\" id=\"uluslararasi\">\n" +
                "                        <li><a href=\"http://ebs.comu.edu.tr/default.aspx\" target=\"_blank\" title=\"Eğitim Bilgi Sistemi\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Eğitim Bilgi Sistemi (EBS)</a></li>\n" +
                "                        <li><a href=\"http://bologna.comu.edu.tr\" target=\"_blank\" title=\"Bologna\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Bologna </a></li>\n" +
                "                        <li><a href=\"http://iro.comu.edu.tr\" target=\"_blank\" title=\"İro\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Dış İlişkiler Koordinatörlüğü</a></li>\n" +
                "                        <li><a href=\"http://farabi.comu.edu.tr\" target=\"_blank\" title=\"Farabi\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Farabi Programı</a></li>\n" +
                "                        <li><a href=\"http://teachandtravel.comu.edu.tr\" target=\"_blank\" title=\"Teach And Travel\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Teach And Travel </a></li>\n" +
                "                        <li><a href=\"http://student.comu.edu.tr/\" target=\"_blank\" title=\"YÖS\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> YÖS - Yabancı Öğrenci Sınavı</a></li>\n" +
                "                    </ul>\n" +
                "\n" +
                "                <li data-toggle=\"collapse\" data-target=\"#ihale\" class=\"collapsed\">\n" +
                "                    <a href=\"javascript:void(0)\"><i class=\"fas fa-angle-down\"></i> İdari Hizmetler</a>\n" +
                "                </li>\n" +
                "                    <ul class=\"sub-menu collapse\" id=\"ihale\">\n" +
                "                        <li><a href=\"/yonetmelikler\" title=\"Yönetmelik ve Yönergeler\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Yönetmelik ve Yönergeler</a></li>\n" +
                "                        <li><a href=\"/kararlar\" title=\"Yönetim Kurulu ve Senato Kararları\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Yönetim Kurulu ve Senato Kararları</a></li>\n" +
                "                        <li><a href=\"http://personel.comu.edu.tr/mevzuatlar/akademik-kadro-atama-kriterleri.html\" title=\"\"><span class=\"glyphicon glyphicon-link\" aria-hidden=\"true\"></span> Akademik Personel Atanma ve Yükseltilme Kriterleri</a></li>\n" +
                "                    </ul>\n" +
                "               \n" +
                "                \n" +
                "            </ul>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>                <div class=\"col-md-9 col-sm-8 col-xs-12 fix-sm mobilTopE\">\n" +
                "                    <div class=\"altsayfaicerik\">\n" +
                "                        <div class=\"bread pull-left hidden-xs\">\n" +
                "                            <div id=\"bc1\" class=\"btn-group btn-breadcrumb\">\n" +
                "                                <a href=\"//www.comu.edu.tr\" class=\"btn btn-default\"><i class=\"fa fa-home\"></i></a>\n" +
                "                                <a href=\"/haberler.html\" class=\"btn btn-default\"><div>Haberler</div></a>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"sayfalar\">\n" +
                "                            <table class=\"table table-bordered table-hover\" id=\"tumHaberler\">\n" +
                "                                <thead>\n" +
                "                                    <tr>\n" +
                "                                        <th>Başlık</th>\n" +
                "                                        <th>Yayınlanma Zamanı</th>\n" +
                "                                        <th>Görüntülenme</th>\n" +
                "                                    </tr>\n" +
                "                                </thead>\n" +
                "                                <tbody>\n" +
                "                                                                            <tr id=\"18874\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18874.html\" target=\"_blank\" title=\"5. Hastane Öncesi Acil Sağlık Hizmetleri Paneli ve Medi-Ralli Yarışması\">5. Hastane Öncesi Acil Sağlık Hizmetleri Paneli ve Medi-Ralli Yarışması</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 19.04.2019 09:48</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 25</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18866\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18866.html\" target=\"_blank\" title=\"Trakya &Uuml;niversiteler Birliği &Uuml;yesi &Uuml;niversitelerin &Ouml;ğrencileri &Ccedil;anakkale Şehitlerini Andı\">Trakya &Uuml;niversiteler Birliği &Uuml;yesi &Uuml;niversitelerin &Ouml;ğrencileri &Ccedil;anakkale Şehitlerini Andı</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 16.04.2019 09:11</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 292</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18865\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18865.html\" target=\"_blank\" title=\"&Ccedil;OM&Uuml;&rsquo;den Devlet Eski Bakanı Cavit &Ccedil;ağlar&rsquo;a Ziyaret\">&Ccedil;OM&Uuml;&rsquo;den Devlet Eski Bakanı Cavit &Ccedil;ağlar&rsquo;a Ziyaret</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 16.04.2019 08:34</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 738</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18852\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18852.html\" target=\"_blank\" title=\"ÇOMÜ – Ziraat Sigorta Arasında BES Protokolü 1 Yıl Daha Uzatıldı\">ÇOMÜ – Ziraat Sigorta Arasında BES Protokolü 1 Yıl Daha Uzatıldı</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 09.04.2019 10:11</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 591</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18845\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18845.html\" target=\"_blank\" title=\"Gen&ccedil; M&Uuml;SİAD, K&uuml;t&uuml;phanedeki &Ouml;ğrencilere &Ccedil;orba İkram Etti\">Gen&ccedil; M&Uuml;SİAD, K&uuml;t&uuml;phanedeki &Ouml;ğrencilere &Ccedil;orba İkram Etti</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 05.04.2019 17:03</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 578</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18844\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18844.html\" target=\"_blank\" title=\"'ÇOMÜ Ziraat Fakültesi Çiftliği' Markası Tescillendi\">'ÇOMÜ Ziraat Fakültesi Çiftliği' Markası Tescillendi</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 05.04.2019 10:34</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 716</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18840\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18840.html\" target=\"_blank\" title=\"&Ccedil;an Meslek Y&uuml;ksekokulu EXPOMED EUROSIA&rsquo;DA\">&Ccedil;an Meslek Y&uuml;ksekokulu EXPOMED EUROSIA&rsquo;DA</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 04.04.2019 16:21</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 34</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18834\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18834.html\" target=\"_blank\" title=\"ÇOMÜ Tiyatro Topluluğu “Komik Aynalar” Oyununu Sergiledi\">ÇOMÜ Tiyatro Topluluğu “Komik Aynalar” Oyununu Sergiledi</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 02.04.2019 15:32</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 60</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18832\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18832.html\" target=\"_blank\" title=\"&Ouml;ğretim &Uuml;yemizin Araştırması H&uuml;rriyet Gazetesinde\">&Ouml;ğretim &Uuml;yemizin Araştırması H&uuml;rriyet Gazetesinde</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 02.04.2019 10:14</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 646</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18831\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18831.html\" target=\"_blank\" title=\"Çamkalabaklı Kadınlar El Emeklerini Sanata Dönüştürdüler\">Çamkalabaklı Kadınlar El Emeklerini Sanata Dönüştürdüler</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 02.04.2019 09:02</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 601</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18829\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18829.html\" target=\"_blank\" title=\"Kolombiya Ulusal &Uuml;niversitesi&rsquo;nde Bir &Ccedil;OM&Uuml;&rsquo;l&uuml;\">Kolombiya Ulusal &Uuml;niversitesi&rsquo;nde Bir &Ccedil;OM&Uuml;&rsquo;l&uuml;</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 01.04.2019 10:27</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 578</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18828\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18828.html\" target=\"_blank\" title=\"&Ccedil;anakkale Onsekiz Mart &Uuml;niversitesi ile Bah&ccedil;eşehir Koleji Arasında Değerli İşbirliği\">&Ccedil;anakkale Onsekiz Mart &Uuml;niversitesi ile Bah&ccedil;eşehir Koleji Arasında Değerli İşbirliği</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 29.03.2019 15:45</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 1871</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18827\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18827.html\" target=\"_blank\" title=\"&Ccedil;OM&Uuml;&rsquo;n&uuml;n Gelişen Spor Alt Yapısı Başarılar Getiriyor\">&Ccedil;OM&Uuml;&rsquo;n&uuml;n Gelişen Spor Alt Yapısı Başarılar Getiriyor</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 29.03.2019 14:01</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 493</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18824\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18824.html\" target=\"_blank\" title=\"TÖMER Öğrencilerine Yönelik Şehitlik Gezisi Düzenlendi\">TÖMER Öğrencilerine Yönelik Şehitlik Gezisi Düzenlendi</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 29.03.2019 10:06</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 394</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18821\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18821.html\" target=\"_blank\" title=\"Ayvacık MYO Öğretim Görevlisinden Büyük Başarı\">Ayvacık MYO Öğretim Görevlisinden Büyük Başarı</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 29.03.2019 09:53</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 797</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18818\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18818.html\" target=\"_blank\" title=\"Akuak&uuml;lt&uuml;r End&uuml;strisi ve Araştırmalarında Tecr&uuml;beler &Ccedil;OM&Uuml;&rsquo;de Konuşuldu\">Akuak&uuml;lt&uuml;r End&uuml;strisi ve Araştırmalarında Tecr&uuml;beler &Ccedil;OM&Uuml;&rsquo;de Konuşuldu</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 29.03.2019 16:33</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 329</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18813\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18813.html\" target=\"_blank\" title=\"İŞKUR  Kariyer G&uuml;nleri  Etkinliği &Ccedil;OM&Uuml;&rsquo;de Ger&ccedil;ekleşti\">İŞKUR  Kariyer G&uuml;nleri  Etkinliği &Ccedil;OM&Uuml;&rsquo;de Ger&ccedil;ekleşti</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 27.03.2019 16:49</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 556</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18800\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18800.html\" target=\"_blank\" title=\"Humboldt Bursunu Kazanan Doç. Dr. Ekin Kozal’dan  Rektör Prof. Dr. Acer’e Ziyaret\">Humboldt Bursunu Kazanan Doç. Dr. Ekin Kozal’dan  Rektör Prof. Dr. Acer’e Ziyaret</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 25.03.2019 15:16</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 375</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18799\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18799.html\" target=\"_blank\" title=\"Emekli JICA Uzmanı ve Uluslararası Akuakültür Danışmanı Noboru Takeno’dan Rektör Acer’e Ziyaret\">Emekli JICA Uzmanı ve Uluslararası Akuakültür Danışmanı Noboru Takeno’dan Rektör Acer’e Ziyaret</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 25.03.2019 15:06</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 244</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18790\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18790.html\" target=\"_blank\" title=\"D&uuml;nyanın En Başarılı 5G &Ouml;rnek Uygulamalarından Biri &Ccedil;anakkale Teknoparkta Geliştirildi\">D&uuml;nyanın En Başarılı 5G &Ouml;rnek Uygulamalarından Biri &Ccedil;anakkale Teknoparkta Geliştirildi</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 25.03.2019 09:40</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 511</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18789\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18789.html\" target=\"_blank\" title=\"Askeri Tarih &Ccedil;alışmaları Konusunda HAVELSAN İle İşbirliği Protokol&uuml; İmzalandı\">Askeri Tarih &Ccedil;alışmaları Konusunda HAVELSAN İle İşbirliği Protokol&uuml; İmzalandı</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 22.03.2019 17:59</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 641</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18785\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18785.html\" target=\"_blank\" title=\"Cüceloğlu ve Doğru’dan Yaşam ve Gelecek Üstüne Söyleşi\">Cüceloğlu ve Doğru’dan Yaşam ve Gelecek Üstüne Söyleşi</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 22.03.2019 10:22</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 473</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18783\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18783.html\" target=\"_blank\" title=\"ÇOMÜ Öğrenci Konseyi, 92 Üniversite Başkanına Ev Sahipliği Yaptı\">ÇOMÜ Öğrenci Konseyi, 92 Üniversite Başkanına Ev Sahipliği Yaptı</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 21.03.2019 16:35</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 678</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18782\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18782.html\" target=\"_blank\" title=\"TYPE UNITE 2018 Uluslararası Tipografik Poster Sergisi Açıldı\">TYPE UNITE 2018 Uluslararası Tipografik Poster Sergisi Açıldı</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 21.03.2019 16:18</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 405</td>\n" +
                "                                        </tr>\n" +
                "                                                                            <tr id=\"18780\">\n" +
                "                                            <td><i class=\"fa fa-angle-right\" aria-hidden=\"true\"></i> <a href=\"http://www.comu.edu.tr/haber-18780.html\" target=\"_blank\" title=\"ÇOMÜ’nün Doğduğu Anafartalar Yerleşkesi 27 Milyonluk Yatırımla Yenilendi\">ÇOMÜ’nün Doğduğu Anafartalar Yerleşkesi 27 Milyonluk Yatırımla Yenilendi</a></td>\n" +
                "                                            <td><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i> 21.03.2019 14:11</td>                                           \n" +
                "                                            <td><i class=\"fa fa-eye\" aria-hidden=\"true\"></i> 2688</td>\n" +
                "                                        </tr>\n" +
                "                                                                    </tbody>\n" +
                "                            </table>\n" +
                "                            <div class=\"box-footer clearfix\">\n" +
                "                                <ul class=\"pagination pagination-sm no-margin pull-right\">\n" +
                "                                <li><a class=\"current\" href=\"/haberler-1.html\" title=\"1. Sayfa\"> 1 </a><a class=\"passive\" href=\"/haberler-2.html\" title=\"2. Sayfa\"> 2 </a><a class=\"passive\" href=\"/haberler-3.html\" title=\"3. Sayfa\"> 3 </a><a class=\"passive\" href=\"/haberler-4.html\" title=\"4. Sayfa\"> 4 </a><a class=\"passive\" href=\"/haberler-5.html\" title=\"5. Sayfa\"> 5 </a><a class=\"passive\" href=\"/haberler-6.html\" title=\"6. Sayfa\"> 6 </a><a class=\"passive\" href=\"/haberler-7.html\" title=\"7. Sayfa\"> 7 </a><a class=\"passive\" href=\"/haberler-8.html\" title=\"8. Sayfa\"> 8 </a><a class=\"passive\" href=\"/haberler-9.html\" title=\"9. Sayfa\"> 9 </a><a class=\"passive\" href=\"/haberler-10.html\" title=\"10. Sayfa\"> 10 </a><a class=\"passive\" href=\"/haberler-11.html\" title=\"11. Sayfa\"> 11 </a><a href=\"/haberler-379.html\"> Son Sayfa </a></li>                                </ul>\n" +
                "                            </div>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"altsayfaHizli\">\n" +
                "    <div class=\"col-md-12\">\n" +
                "    <div class=\"row hizliButonCenter\">\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"https://ubys.comu.edu.tr\" title=\"ÜBYS\" data-toggle=\"tooltip\" data-original-title=\"Übys\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-file-alt fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>Üniversite Bilgi Yönetim Sistemi</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"https://ubys.comu.edu.tr\" title=\"Öğrenci Bilgi Sistemi\" data-toggle=\"tooltip\" data-original-title=\"Öğrenci Bilgi Sistemi\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-users fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>Öğrenci Bilgi Sistemi</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://ogrenciisleri.comu.edu.tr/akademik-takvim/akademik-takvim.html\" title=\"Akademik Takvim\" data-toggle=\"tooltip\" data-original-title=\"Akademik Takvim\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-calendar-alt fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>Akademik Takvim</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://hastane.comu.edu.tr/\" title=\"Hastane\" data-toggle=\"tooltip\" data-original-title=\"Hastane\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-h-square fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>Hastane</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://aves.comu.edu.tr/\" title=\"AVES\" data-toggle=\"tooltip\" data-original-title=\"AVES\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-graduation-cap fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>AVES</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://proje.comu.edu.tr/\" title=\"Proje Koordinasyon Merkezi\" data-toggle=\"tooltip\" data-original-title=\"Proje Koordinasyon Merkezi\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-parking fa-2x  hizli-icon\"></i>\n" +
                "                    <span>Proje Koordinasyon</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://student.comu.edu.tr/\" title=\"International Students Office\" data-toggle=\"tooltip\" data-original-title=\"International Students Office\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-globe fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>International Students Office</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://radyo.comu.edu.tr/\" title=\"ÇOMÜ Radyo\" data-toggle=\"tooltip\" data-original-title=\"ÇOMÜ Radyo\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-microphone-alt fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>ÇOMÜ Radyo</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://tv.comu.edu.tr/\" title=\"ÇOMÜ TV\" data-toggle=\"tooltip\" data-original-title=\"ÇOMÜ TV\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-tv fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>ÇOMÜ TV</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://sks.comu.edu.tr/yemek-listesi.html\" title=\"ÇOMÜ Yemek Listesi\" data-toggle=\"tooltip\" data-original-title=\"Yemek Listesi\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-utensils fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>Yemek Listesi</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://lib.comu.edu.tr/\" title=\"ÇOMÜ Kütüphane\" data-toggle=\"tooltip\" data-original-title=\"ÇOMÜ Kütüphane\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-book fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>ÇOMÜ Kütüphane</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "        <div class=\"col-md-1 col-sm-2 col-xs-4\">\n" +
                "            <a href=\"http://eposta.comu.edu.tr/\" title=\"ÇOMÜ E-posta\" data-toggle=\"tooltip\" data-original-title=\"ÇOMÜ E-posta\" class=\"hizliTool\">\n" +
                "                <div class=\"hizli-btn-kapsa\">\n" +
                "                    <i class=\"fas fa-envelope-open fa-2x hizli-icon\" aria-hidden=\"true\"></i>\n" +
                "                    <span>ÇOMÜ E-posta</span>\n" +
                "                </div>\n" +
                "            </a>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "</div></div>\n" +
                "\t\t\t\t\t        </div>\n" +
                "    </div>\n" +
                "    <footer class=\"foobar\">\n" +
                "    <div id=\"footerlogo\"></div>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <div class=\"col-md-3 col-sm-6 col-xs-12\">\n" +
                "                <div class=\"footer-widget\">\n" +
                "                    <h4 class=\"footer-baslik\">ÖĞRENCİ</h4>\n" +
                "                    <ul class=\"list-links\">\n" +
                "                        <li><a href=\"https://ubys.comu.edu.tr\" target=\"_blank\">Öğrenci Bilgi Sistemi</a></li>\n" +
                "                        <li><a href=\"http://ogrenciisleri.comu.edu.tr\" target=\"_blank\">Öğrenci İşleri Daire Başkanlığı</a></li>\n" +
                "                        <li><a href=\"http://ogrenciisleri.comu.edu.tr/akademiktakvim\" target=\"_blank\">Akademik Takvim</a></li>\n" +
                "                        <li><a href=\"http://otk.comu.edu.tr\" target=\"_blank\">Öğrenci Temsilcileri Konseyi</a></li>\n" +
                "                        <li><a href=\"http://ekb.comu.edu.tr\" target=\"_blank\">Engelsiz Çomü Öğrenci Birimi</a></li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"col-md-3 col-sm-6 col-xs-12\">\n" +
                "                <div class=\"footer-widget\">\n" +
                "                    <h4 class=\"footer-baslik\">KAMPÜSTE YAŞAM</h4>\n" +
                "                    <ul class=\"list-links\">\n" +
                "                        <li><a href=\"http://sks.comu.edu.tr/beslenme-sube/osem.html\" target=\"_blank\">Yemekhane Ve Kafeteryalar</a></li>\n" +
                "                        <li><a href=\"http://lib.comu.edu.tr\" target=\"_blank\">Kütüphane</a></li>\n" +
                "                        <li><a href=\"http://dardanos.comu.edu.tr/index\" target=\"_blank\">Sosyal Tesisler</a></li>\n" +
                "                        <li><a href=\"http://sks.comu.edu.tr/yemek-listesi/yemek-listesi.html\" target=\"_blank\">Yemek Listesi </a></li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"col-md-3 col-sm-6 col-xs-12\">\n" +
                "                <div class=\"footer-widget\">\n" +
                "                    <h4 class=\"footer-baslik\">BAĞLANTILAR</h4>\n" +
                "                    <ul class=\"list-links\">\n" +
                "                        <li><a href=\"http://erasmus.comu.edu.tr/index\" target=\"_blank\">Erasmus Programı</a></li>\n" +
                "                        <li><a href=\"http://farabi.comu.edu.tr\" target=\"_blank\">Farabi Değişim Programı</a></li>\n" +
                "                        <li><a href=\"http://teknopark.comu.edu.tr\" target=\"_blank\">Teknopark</a></li>\n" +
                "                        <li><a href=\"http://cocuklarevi.comu.edu.tr\" target=\"_blank\">Çocuklar Evi</a></li>\n" +
                "                        <li><a href=\"http://comukart.comu.edu.tr\" target=\"_blank\">Çomü Kart</a></li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"col-md-3 col-sm-6 col-xs-12\">\n" +
                "                <div class=\"footer-widget\">\n" +
                "                    <h4 class=\"footer-baslik\">İletişim</h4>\n" +
                "                    <ul class=\"list-links\">\n" +
                "                        <li class=\"listyok\"><span><i class=\"fas fa-phone\"></i></span>+90 (286) 218 00 18</li>\n" +
                "                        <li class=\"listyok\"><span><i class=\"fas fa-fax\"></i></span>+90 (286) 218 06 08</li>\n" +
                "                        <li class=\"listyok\"><span><i class=\"fas fa-envelope-open\"></i></span>bilgiedinme@comu.edu.tr</li>\n" +
                "                        <li class=\"listyok\"><span><i class=\"fas fa-award\"></i></span><a href=\"https://www.comu.edu.tr/kunye\" target=\"_blank\">Künye</a></li>\n" +
                "                    </ul>\n" +
                "                    <ul class=\"footersocial\">\n" +
                "                        <li><a href=\"https://www.facebook.com/onsekizmartuni\" class=\"facebook\" target=\"_blank\"></a></li>\n" +
                "                        <li><a href=\"https://twitter.com/onsekizmartuni\" class=\"twitter\" target=\"_blank\"></a></li>\n" +
                "                        <li><a href=\"https://www.youtube.com/user/OnsekizMartUni\" class=\"youtube\" target=\"_blank\"></a></li>\n" +
                "                        <li><a href=\"https://plus.google.com/114922856483406230073/posts\" class=\"gplus\" target=\"_blank\"></a></li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"bottom-footer\">\n" +
                "            <div class=\"row\">\n" +
                "                <p class=\"small-text\">&copy;\n" +
                "                    Copyright 1992-2016 <a href=\"http://www.comu.edu.tr\" title=\"üniversite\"><strong>Çanakkale Onsekiz Mart Üniversitesi</strong></a> » <a href=\"http://bidb.comu.edu.tr\" title=\"Bilgi İşlem\">Bilgi İşlem Daire Başkanlığı</a>\n" +
                "                </p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</footer>\n" +
                "    <script src=\"assets/js/jquery-1.11.1.min.js\"></script>\t\n" +
                "    <script src=\"assets/js/bootstrap.min.js\"></script> \n" +
                "    <script src=\"assets/js/cws.js\"></script>\n" +
                "   \n" +
                "    </body>\n" +
                "</html>";
        this.html = Jsoup.parse(a);
    //Jsoup.connect(url).get();
    }

    protected void findTable(String tags){
        this.table = this.html.select(tags);

    }

    protected Elements getTable() {
        return table;
    }

    protected   String  findLink(String tags, int id){
        return this.table.get(id).select(tags).attr("href");
                //.select(tags).get(id).attr("href");
    }

    protected String findTitle(String tags, int id){
      return    this.table.get(id).text();
    }

}
