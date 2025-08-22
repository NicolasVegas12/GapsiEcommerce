# 📱 App Android Multi‑Modular Ecommerce

**Stack:** Kotlin • Clean Architecture • Coroutines/Flow • Hilt • Retrofit/OkHttp • Room • Compose

Este README describe cómo estructurar, configurar y ejecutar una app Android multi‑módulo que consume una API vía Retrofit y persiste datos con Room, siguiendo principios de Clean Architecture. Incluye la **configuración obligatoria** de archivos `server.properties` (URL base) y `keystore.properties` (API key).

---

## 🗂️ Estructura de módulos 

```
root
├─ app                     
├─ core
├─ domain                   
├─ data                     
└─ presentation
```


