# Basit Veteriner Sistemi
Müşteri ve hayvan bilgilerinin oluşturulup düzenlenebileceği bir sistem. 


# Proje Gereksinimleri

 - Mysql
 - Java 1.8

## Veritabanı ve Tabloların Oluşturulması

Yukarıdaki gereksinimler kurulduktan sonra proje yürütüldüğünde, ilgili veritabanı ve bu veritabanına ait tablolar otomatik olarak oluşturulacaktır.


## Yetkilendirme

Sistem otomatik olarak username:vetsysadmin password:vetsysadmin bilgilerine sahip, admin rolünde bir kullanıcı oluşturacaktır. Bu kullanıcı tüm kayıtlar üzerinde tüm işlemleri yapma yetkisine sahiptir.
Signup form doldurularak oluşturulacak yeni kayıtlar, admin rolune sahip olmayacaktır ve silme işlemlerini gerçekleştiremeyeceklerdir.


## Teknik seçimler

 - Projenin build edilmiş halini -jar ve -war paketlerini de sunmak taşınabilirlik adına daha iyi olurdu. Denemelerde bulundum fakat jsp dosyalarıma erişirken 404 hatası aldım. Bunun için configuration araştırmaları yaptım fakat sorunu çözemedim. Bu nedenle projemi yalnızca kaynak kod olarak göndermek durumunda kaldım.

 - Hayvan sınıf ve türü ile ilgili yeni tablolar kurulup ilişkilendirilebilirdi.
	-> Böylelikle örneğin bir kedinin türünü golden olarak girilmesinin önüne geçilebilirdi. 
		
 - Admin rolündeki kullanıcı diğer kullanıcıların listesini görebilir, diğer kullanıcıların yetkilerini değiştirebilirdi.
  -> Bunun için giriş sayfasında kullanıcı aramaya dayalı bir arama kutucuğu konuldu. Fakat diğer kullanıcıların yetkilerini değiştirmek gibi bir yapı kurulmadı.
  
 - Admin rolündeki kullanıcının ilklendirilmesi için, resources içerisindeki data.sql den faydalanıldı. Sistem yürütüldüğünde bu dosya çalıştırılacak, admin rolündeki vetsysadmin kullanıcısını oluşturacaktır.
