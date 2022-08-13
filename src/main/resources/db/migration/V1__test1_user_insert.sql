DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `fio` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'Petro Petrovich'),(2,'Ivan Ivanovich'),(3,'Kiril Kirilovich'),(4,'Fedya Fedyovich');
UNLOCK TABLES;