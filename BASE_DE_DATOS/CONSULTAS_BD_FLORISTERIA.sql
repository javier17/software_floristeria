USE FLORISTERIA;

SELECT * FROM CATEGORIAS;

INSERT INTO CATEGORIAS(NOMBRE, DESCRIPCION, FOTO, FECHA_CREACION, ESTADO, ID_PADRE_CATEGORIA) 
VALUES ('ARREGLOS FLORALES', 'CATEGORIA PARA ARREGLOS FLORALES', 'imagen.png', '2023-03-21', 1, NULL);


COMMIT;