## Native map backend

### Описание
- Сервер работает на порте `8080`
- Статические файлы (фото) загружаются в `static/media`. Для их загрузки нужно обратиться к `/media/имя_файла`
- Каждый запуск база очищается, для отключения этого можно поменять в `application.yaml` `ddl-auto` на `update`

### Запуск
1. Запускаем postgres с помощью `docker compose up -d`
2. Запускаем сервер