
# Invoice Management System

Bu proje, Java Spring Boot kullanılarak geliştirilmiş basit bir fatura yönetim sistemidir. Temel amacı, müşteri-fatura ilişkisini yönetmek, güvenli endpoint erişimi sağlamak ve gerçek hayattaki muhasebe yazılımlarının temel yapısını örneklemektir.

## 🚀 Özellikler

- Müşteri oluşturma
- Fatura oluşturma ve listeleme
- Spring Security ile Basic Auth yetkilendirme
- Rol bazlı endpoint erişimi (MANAGER ve USER)
- In-memory kullanıcı yönetimi (İlk sürüm için)
- Open Liberty üzerinde deploy edilmiştir

## 🛠️ Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.4.4
- Spring Security
- Lombok
- Open Liberty (Servlet konteyner)
- Maven

## 👥 Roller ve Giriş Bilgileri

| Kullanıcı Adı | Şifre | Roller           |
|---------------|-------|------------------|
| Batuhan       | 123   | USER             |
| Han           | 456   | USER, MANAGER    |

## ⚙️ Kurulum

```bash
git clone https://github.com/cbasanbuga/Invoice-Management-System.git
cd Invoice-Management-System
mvn clean install
mvn spring-boot:run
```