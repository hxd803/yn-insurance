-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: yn_insurance
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_id` int NOT NULL DEFAULT '0' COMMENT '上级ID',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '菜单类型（0：菜单，1：按钮，2：数据）',
  `permission_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限url',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`id`, `parent_id`, `code`, `name`, `type`, `permission_url`, `is_delete`, `create_time`, `update_time`) VALUES (1,0,'HOME','首页',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(2,0,'SYSTEM_MANAGE','系统管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(3,2,'ROLE_MANAGE','角色管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(4,2,'MENU_MANAGE','菜单管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(5,2,'USER_MANAGE','用户管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(6,3,'ROLE_CREATE','创建角色',1,'/api/manage/role/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(7,3,'ROLE_EDIT','修改角色',1,'/api/manage/role/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(8,3,'ROLE_DELETE','删除角色',1,'/api/manage/role/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(10,0,'TEST_ROOT_1','TEST_ROOT_1',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(11,10,'TEST_ROOT_SON_1','TEST_ROOT_SON_1_1',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(12,11,'TEST_ROOT_SON_1_1_SON_1','TEST_ROOT_SON_1_1_SON_1',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(13,12,'TEST_ROOT_SON_1_1_SON_1_SON_1','TEST_ROOT_SON_1_1_SON_1_SON_1',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(14,3,'ROLE_LIST','角色列表',2,'/api/manage/role/list',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(15,4,'MENU_TREE_LIST','菜单树形列表',2,'/api/manage/menu/treeTable',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(16,4,'MENU_CREATE','新建一级菜单',1,'/api/manage/menu/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(17,4,'MENU_UPDATE','修改菜单',1,'/api/manage/menu/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(18,4,'MENU_DELETE','删除菜单',1,'/api/manage/menu/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(19,4,'MENU_CREATE_SON','新建子菜单',1,'/api/manage/menu/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(20,5,'USER_LIST','用户列表',2,'/api/manage/user/list',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(21,5,'USER_ADD','新建用户',1,'/api/manage/user/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(22,5,'USER_UPDATE','修改用户',1,'/api/manage/user/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(23,5,'USER_ENABLE','用户启用',1,'/api/manage/user/enable',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(24,5,'USER_DISABLE','用户禁用',1,'/api/manage/user/disable',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(25,5,'USER_DELETE','删除用户',1,'/api/manage/user/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(26,5,'USER_GET2EDIT','获取改用户数据2修改',2,'/api/manage/user/get2Edit',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(27,3,'ROLE_FIND_ALL','获取所有角色',2,'/api/manage/role/findAll',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(28,0,'BPMN_RUMEN','BPMN入门',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(29,0,'WORKFLOW_MANAGE','流程管理',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(30,29,'WORKFLOW_DATEGORY_MANAGE','流程分类管理',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(31,30,'WORKFLOW_DATEGORY_CREATE','创建流程分类',1,'/api/manage/workflow/category/create',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(32,30,'WORKFLOW_DATEGORY_UPDATE','修改流程分类',1,'/api/manage/workflow/category/update',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(33,30,'WORKFLOW_DATEGORY_DELETE','删除流程分类',1,'/api/manage/workflow/category/delete',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(34,30,'WORKFLOW_DATEGORY_LIST','流程分类列表',2,'/api/manage/workflow/category/list',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(35,30,'WORKFLOW_DATEGORY_FIND_ALL','获取所有流程分类',2,'/api/manage/workflow/category/findAll',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(36,29,'WORKFLOW_MODEL_MANAGE','流程模型管理',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(37,36,'WORKFLOW_MODEL_LIST','流程模型列表',2,'/api/manage/workflow/model/list',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(38,36,'WORKFLOW_MODEL_CREATE','创建流程模型',1,'/api/manage/workflow/model/create',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(39,36,'WORKFLOW_MODEL_DELETE','删除流程模型',1,'/api/manage/workflow/model/delete',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(40,36,'WORKFLOW_MODEL_UPDATE','修改流程模型',1,'/api/manage/workflow/model/update',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(41,36,'WORKFLOW_MODEL_GET_BPMN_XML','获取流程模型的Bpmn',2,'/api/manage/workflow/model/getBpmnXml',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(42,36,'WORKFLOW_MODEL_SAVE_BPMN_XML','保存流程模型的Bpmn',2,'/api/manage/workflow/model/saveBpmnXml',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(43,29,'WORKFLOW_DEPLOYMENT_MANAGE','流程模型管理',0,'',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(44,43,'WORKFLOW_DEPLOYMENT_LIST','流程模型列表',2,'/api/manage/workflow/deployment/list',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(47,43,'WORKFLOW_DEPLOYMENT_CREATE','创建流程发布',1,'/api/manage/workflow/deployment/create',_binary '','2020-07-31 18:24:45','2020-07-31 18:24:45'),(48,2,'REGION_MANAGE','行政区划',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(49,48,'REGION_MANAGE_LAZYTREE','行政区划懒加载树',2,'/api/manage/region/lazyTree',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(50,48,'REGION_MANAGE_DETAIL','行政区划详情',2,'/api/manage/region/detail',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(51,48,'REGION_MANAGE_CREATE','新建区划',1,'/api/manage/region/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(52,48,'REGION_MANAGE_UPDATE','修改区划',1,'/api/manage/region/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(53,48,'REGION_MANAGE_DELETE','删除区划',1,'/api/manage/region/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(54,2,'ORGANIZE_MANAGE','组织管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(55,54,'ORGANIZE_MANAGE_LAZYTREE','组织懒加载树',2,'/api/manage/organize/lazyTree',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(56,54,'ORGANIZE_MANAGE_DETAIL','组织详情',2,'/api/manage/organize/detail',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(57,54,'ORGANIZE_MANAGE_CREATE','新建组织',1,'/api/manage/organize/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(58,54,'ORGANIZE_MANAGE_UPDATE','修改组织',1,'/api/manage/organize/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(59,54,'ORGANIZE_MANAGE_DELETE','删除组织',1,'/api/manage/organize/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(60,54,'ORGANIZE_MANAGE_TREE','组织完整树',2,'/api/manage/organize/tree',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(61,2,'DICT_MANAGE','数据字典',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(62,61,'DICT_MANAGE_LAZYTREE','数据字典懒加载树',2,'/api/manage/dict/lazyTree',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(63,61,'DICT_MANAGE_DETAIL','数据字典详情',2,'/api/manage/dict/detail',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(64,61,'DICT_MANAGE_CREATE','新建字典',1,'/api/manage/dict/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(65,61,'DICT_MANAGE_UPDATE','修改字典',1,'/api/manage/dict/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(66,61,'DICT_MANAGE_DELETE','删除字典',1,'/api/manage/dict/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(67,0,'ARTICLE_MANAGE','文档管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(68,67,'ARTICLE_MANAGE_LIST','文档列表',2,'/api/manage/article/list',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(70,67,'ARTICLE_MANAGE_CREATE','新建文档',1,'/api/manage/article/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(71,67,'ARTICLE_MANAGE_UPDATE','修改文档',1,'/api/manage/article/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(72,67,'ARTICLE_MANAGE_DELETE','删除文档',1,'/api/manage/article/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(73,91,'MERCHANT_USER_MANAGE','商户操作员管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(74,73,'MERCHANT_USER_LIST','商户操作员列表',2,'/api/manage/merchant-user/list',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(75,73,'MERCHANT_USER_ADD','新建商户操作员',1,'/api/manage/merchant-user/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(76,73,'MERCHANT_USER_UPDATE','修改商户操作员',1,'/api/manage/merchant-user/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(77,73,'MERCHANT_USER_ENABLE','商户操作员启用',1,'/api/manage/merchant-user/enable',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(78,73,'MERCHANT_USER_DISABLE','商户操作员禁用',1,'/api/manage/merchant-user/disable',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(79,73,'MERCHANT_USER_DELETE','删除商户操作员',1,'/api/manage/merchant-user/delete',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(80,73,'MERCHANT_USER_GET2EDIT','获取改商户操作员数据2修改',2,'/api/manage/merchant-user/get2Edit',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(81,73,'MERCHANT_USER_RESET_PWD','商户操作员重置登录密码',1,'/api/manage/merchant-user/resetPassword',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(82,0,'PLATFORM_INFO_MANAGE','服务平台信息管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(83,82,'PLATFORM_INFO_LIST','服务平台列表',2,'/api/manage/service-platform/list',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(84,82,'PLATFORM_INFO_UPDATE','修改服务平台信息',1,'/api/manage/service-platform/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(85,82,'PLATFORM_INFO_GET','服务平台GET',2,'/api/manage/service-platform/get',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(86,91,'MERCHANT_INFO_MANAGE','商户信息管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(87,86,'MERCHANT_INFO_LIST','商户列表',2,'/api/manage/merchant/list',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(88,86,'MERCHANT_INFO_ADD','新建商户',1,'/api/manage/merchant/create',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(89,86,'MERCHANT_INFO_UPDATE','修改商户',1,'/api/manage/merchant/update',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(90,86,'MERCHANT_INFO_GET','商户GET',1,'/api/manage/merchant/get',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(91,0,'MERCHANT_MANAGE','商户管理',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(92,91,'MERCHANT_RATE_CONFIG','费率配置',0,'',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(93,91,'RATE_CONFIG_SUBMIT','费率配置提交',1,'/api/manage/merchant/rate-config',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(94,91,'GET_CONTRACT_LIST','合同照片列表',1,'/api/manage/merchant/contract-list',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45'),(95,91,'UPLOAD_CONTRACT','上传合同照片',1,'/api/manage/merchant/upload-contract',_binary '\0','2020-07-31 18:24:45','2020-07-31 18:24:45');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `describe` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `code`, `name`, `describe`, `is_delete`) VALUES (1,'ADMIN','系统管理员','系统管理员',_binary '\0'),(2,'OPERATE','运营','运营人员',_binary '\0'),(3,'EMP','员工','普通员工asfsdfasdfasdf',_binary ''),(4,'EMP','员工','普通员工',_binary ''),(5,'TEST','测试11111','测试12121212',_binary ''),(6,'DEV','开发','开发人员',_binary ''),(7,'DEV','开发','开发人员',_binary ''),(8,'SCM','SCM','aasdfasdfasdf',_binary ''),(9,'TEST','测试','测试描述',_binary '\0'),(10,'','','',_binary ''),(11,'adsddddde','test1111','abcdefg',_binary '');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int NOT NULL DEFAULT '0' COMMENT '角色ID',
  `menu_id` int NOT NULL DEFAULT '0' COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='角色菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES (1,9,2),(2,9,5),(3,9,20),(4,9,21),(5,9,22),(6,9,23),(7,9,24),(8,9,25),(9,2,1),(10,2,2),(11,2,5),(12,2,20),(13,2,21),(14,2,22),(15,2,23),(16,2,24),(17,2,25),(18,1,1),(19,1,2),(20,1,3),(21,1,6),(22,1,7),(23,1,8),(24,1,14),(25,1,27),(26,1,4),(27,1,15),(28,1,16),(29,1,17),(30,1,18),(31,1,19),(32,1,5),(33,1,20),(34,1,21),(35,1,22),(36,1,23),(37,1,24),(38,1,25),(39,1,26),(40,1,48),(41,1,49),(42,1,50),(43,1,51),(44,1,52),(45,1,53),(46,1,54),(47,1,55),(48,1,56),(49,1,57),(50,1,58),(51,1,59),(52,1,60),(53,1,61),(54,1,62),(55,1,63),(56,1,64),(57,1,65),(58,1,66),(59,1,67),(60,1,68),(61,1,70),(62,1,71),(63,1,72),(64,1,82),(65,1,83),(66,1,84),(67,1,85),(68,1,91),(69,1,73),(70,1,74),(71,1,75),(72,1,76),(73,1,77),(74,1,78),(75,1,79),(76,1,80),(77,1,81),(78,1,86),(79,1,87),(80,1,88),(81,1,89),(82,1,90),(83,1,92),(84,1,93),(85,1,94),(86,1,95);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '租户ID',
  `name` varchar(50) DEFAULT '' COMMENT '租户名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='租户管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` (`id`, `name`, `create_time`, `update_time`) VALUES (1,'租户一','2020-09-10 20:53:01','2020-09-10 20:53:01');
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` int NOT NULL DEFAULT '0' COMMENT '租户ID',
  `login_name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录名',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `mobile` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '盐加密',
  `id_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '身份证号',
  `department` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门',
  `state` int NOT NULL DEFAULT '1' COMMENT '状态（0停用,1启用,2删除）',
  `remark` varchar(200) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `tenant_id`, `login_name`, `username`, `mobile`, `password`, `salt`, `id_card`, `department`, `state`, `remark`, `create_time`, `update_time`) VALUES (1,1,'13900000001','超级管理员','13900000001','8a59bba2559534b4d0dd0f546091d677','701574','330327199005224278','基础部门',1,'','2020-08-18 16:44:21','2020-09-02 11:55:43'),(2,1,'13900000002','三墩管理员','13900000002','f131deaa0f01f3cef67e3ff783729f7a','280703','330327199005224278','行长办公室',0,'','2020-08-19 15:43:39','2020-09-02 11:55:38'),(3,1,'15958723720','黄雪冬','15958723720','8a4e5c38988131d978d699b5eedc1b02','128563','33030319890121091X','1',0,'1','2020-08-28 14:55:24','2020-09-04 09:55:27'),(4,1,'15958723720','黄雪冬','15958723720','8321cad100481a4b05ff3571d7f4b71d','791001','330303198901010101','测试',2,'测试','2020-08-31 18:15:37','2020-09-01 11:22:19'),(5,1,'13754322565','拱墅管理员','13754322565','1be49e08aa0a5dbe6fb9054f047b1d2c','675750','330327199005224278','技术部',1,'测试','2020-09-04 09:56:57','2020-09-04 09:56:57');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int NOT NULL DEFAULT '0' COMMENT '用户ID',
  `role_id` int NOT NULL DEFAULT '0' COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES (1,1,1),(2,2,9),(3,4,9),(4,4,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-10 22:15:33
