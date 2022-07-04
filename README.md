# APK API
## REST api for storage of .apk files

**Контроллер** **содержит:**

Запрос на загрузку MultipartFile с расширением apk и его метаданных в формате JSON(версия, номер сборки).

Запрос для получения списка версий, хранящихся на сервере.

Запрос для скачивания конкретной версии с сервера.

### В качестве базы данных используется MongoDB.
 
  ### Запрос защищён Basic Authorization, логин и пароль  хранится в настройках. 
