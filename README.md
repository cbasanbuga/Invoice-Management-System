# Invoice Management System

Bu proje, Java Spring Boot ile geliştirilmiş basit bir fatura (invoice) yönetim sistemidir. 
Temel amaç, müşteri-fatura ilişkisini yönetmek, güvenli endpoint erişimi sağlamak ve gerçek hayattaki muhasebe yazılımlarının temel yapısını örneklemektir.

## Özellikler

- Müşteri oluşturma
- Fatura oluşturma ve listeleme
- Spring Security ile Basic Auth yetkilendirme
- Rol bazlı endpoint erişimi (ADMIN ve USER)
- In-memory kullanıcı yönetimi (İlk sürüm için)
- Open Liberty üzerinde deploy edilmiştir

## Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.4.4
- Spring Security
- Lombok
- Open Liberty (Servlet konteyner)
- Maven

## Roller

| Kullanıcı Adı | Şifre | Rol    |
|---------------|-------|--------|
| Batuhan       | 123  | USER  |
| Han           | 456  | USER, MANANGER   |

## API Örnekleri

### Fatura Oluştur

```http
POST /api/invoices
Authorization: Basic (Batuhan / 123)
Content-Type: application/json

{
  "customerId": 1,
  "amount": 500,
  "description": "Yıllık muhasebe hizmeti"
}
