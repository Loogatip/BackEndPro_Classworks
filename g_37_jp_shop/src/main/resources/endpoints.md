1. Не использовать глаголы, в том числе обозначающие CRUD-операции.
   Использовать существительные.

   Неправильво - Х.
   Правильно - V.

   localhost:8080/products/CreateItems ..  - X
   localhost:8080/products?id=7            - V
   POST -> localhost:/products             - V
   
2. Не использовать единственное число, если мы не обращаемся к песурсу-синглтон.
   Использовать множественное число.

   localhost:8080/product?id=7          - X
   localhost:8080/products?id=7         - V
   localhost:8080/price-calculator      - X  (ресулс-синглтон)

3. Не использовать camelCase, слитное написание слов и символов подчеркивания в 
   именах ресурсов-
   Использовать дефис.

   localhost:8080/itemmenagement      - X
   localhost:8080/itemMenagement      - X
   localhost:8080/item_menagement      - X
   localhost:8080/item-menegement      - V

4. Не использоватъь расширение имен файлов.
   Просто опускать их.

   localhost:8080/сторе/итем.йсон     - Х
   localhost:8080/store/item          - V

5. Стараться не передавать параметры для поиска, фильтрации, сортировки в виде подстроки
   
   Использовать параметры.

   Например, получаем продукты из категории с ИД3 и не дороже 100 ед.
   localhost:8080/products/3/100                       - Х
   localhost:8080/products?categoryId=3&maxPrice=100   - V

6. Не использовать сокращенное и не несущее смысла имена параметров

   localhost:8080/users?q=John              - X
   localhost:8080/books?search=history      - X
   localhost:8080/users?name=John           - V
   localhost:8080/books?category=history    - V

7. Не использовать разные форматы для ответа.
   Соблюдать единообразие.