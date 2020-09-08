/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : yn_insurance

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 08/09/2020 18:15:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(255) NOT NULL DEFAULT 0 COMMENT '上级ID',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '菜单类型（0：菜单，1：按钮，2：数据）',
  `permission_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限url',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, 'HOME', '首页', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (2, 0, 'SYSTEM_MANAGE', '系统管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (3, 2, 'ROLE_MANAGE', '角色管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (4, 2, 'MENU_MANAGE', '菜单管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (5, 2, 'USER_MANAGE', '用户管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (6, 3, 'ROLE_CREATE', '创建角色', 1, '/api/manage/role/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (7, 3, 'ROLE_EDIT', '修改角色', 1, '/api/manage/role/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (8, 3, 'ROLE_DELETE', '删除角色', 1, '/api/manage/role/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (10, 0, 'TEST_ROOT_1', 'TEST_ROOT_1', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (11, 10, 'TEST_ROOT_SON_1', 'TEST_ROOT_SON_1_1', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (12, 11, 'TEST_ROOT_SON_1_1_SON_1', 'TEST_ROOT_SON_1_1_SON_1', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (13, 12, 'TEST_ROOT_SON_1_1_SON_1_SON_1', 'TEST_ROOT_SON_1_1_SON_1_SON_1', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (14, 3, 'ROLE_LIST', '角色列表', 2, '/api/manage/role/list', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (15, 4, 'MENU_TREE_LIST', '菜单树形列表', 2, '/api/manage/menu/treeTable', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (16, 4, 'MENU_CREATE', '新建一级菜单', 1, '/api/manage/menu/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (17, 4, 'MENU_UPDATE', '修改菜单', 1, '/api/manage/menu/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (18, 4, 'MENU_DELETE', '删除菜单', 1, '/api/manage/menu/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (19, 4, 'MENU_CREATE_SON', '新建子菜单', 1, '/api/manage/menu/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (20, 5, 'USER_LIST', '用户列表', 2, '/api/manage/user/list', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (21, 5, 'USER_ADD', '新建用户', 1, '/api/manage/user/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (22, 5, 'USER_UPDATE', '修改用户', 1, '/api/manage/user/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (23, 5, 'USER_ENABLE', '用户启用', 1, '/api/manage/user/enable', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (24, 5, 'USER_DISABLE', '用户禁用', 1, '/api/manage/user/disable', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (25, 5, 'USER_DELETE', '删除用户', 1, '/api/manage/user/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (26, 5, 'USER_GET2EDIT', '获取改用户数据2修改', 2, '/api/manage/user/get2Edit', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (27, 3, 'ROLE_FIND_ALL', '获取所有角色', 2, '/api/manage/role/findAll', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (28, 0, 'BPMN_RUMEN', 'BPMN入门', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (29, 0, 'WORKFLOW_MANAGE', '流程管理', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (30, 29, 'WORKFLOW_DATEGORY_MANAGE', '流程分类管理', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (31, 30, 'WORKFLOW_DATEGORY_CREATE', '创建流程分类', 1, '/api/manage/workflow/category/create', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (32, 30, 'WORKFLOW_DATEGORY_UPDATE', '修改流程分类', 1, '/api/manage/workflow/category/update', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (33, 30, 'WORKFLOW_DATEGORY_DELETE', '删除流程分类', 1, '/api/manage/workflow/category/delete', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (34, 30, 'WORKFLOW_DATEGORY_LIST', '流程分类列表', 2, '/api/manage/workflow/category/list', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (35, 30, 'WORKFLOW_DATEGORY_FIND_ALL', '获取所有流程分类', 2, '/api/manage/workflow/category/findAll', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (36, 29, 'WORKFLOW_MODEL_MANAGE', '流程模型管理', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (37, 36, 'WORKFLOW_MODEL_LIST', '流程模型列表', 2, '/api/manage/workflow/model/list', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (38, 36, 'WORKFLOW_MODEL_CREATE', '创建流程模型', 1, '/api/manage/workflow/model/create', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (39, 36, 'WORKFLOW_MODEL_DELETE', '删除流程模型', 1, '/api/manage/workflow/model/delete', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (40, 36, 'WORKFLOW_MODEL_UPDATE', '修改流程模型', 1, '/api/manage/workflow/model/update', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (41, 36, 'WORKFLOW_MODEL_GET_BPMN_XML', '获取流程模型的Bpmn', 2, '/api/manage/workflow/model/getBpmnXml', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (42, 36, 'WORKFLOW_MODEL_SAVE_BPMN_XML', '保存流程模型的Bpmn', 2, '/api/manage/workflow/model/saveBpmnXml', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (43, 29, 'WORKFLOW_DEPLOYMENT_MANAGE', '流程模型管理', 0, '', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (44, 43, 'WORKFLOW_DEPLOYMENT_LIST', '流程模型列表', 2, '/api/manage/workflow/deployment/list', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (47, 43, 'WORKFLOW_DEPLOYMENT_CREATE', '创建流程发布', 1, '/api/manage/workflow/deployment/create', b'1', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (48, 2, 'REGION_MANAGE', '行政区划', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (49, 48, 'REGION_MANAGE_LAZYTREE', '行政区划懒加载树', 2, '/api/manage/region/lazyTree', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (50, 48, 'REGION_MANAGE_DETAIL', '行政区划详情', 2, '/api/manage/region/detail', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (51, 48, 'REGION_MANAGE_CREATE', '新建区划', 1, '/api/manage/region/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (52, 48, 'REGION_MANAGE_UPDATE', '修改区划', 1, '/api/manage/region/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (53, 48, 'REGION_MANAGE_DELETE', '删除区划', 1, '/api/manage/region/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (54, 2, 'ORGANIZE_MANAGE', '组织管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (55, 54, 'ORGANIZE_MANAGE_LAZYTREE', '组织懒加载树', 2, '/api/manage/organize/lazyTree', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (56, 54, 'ORGANIZE_MANAGE_DETAIL', '组织详情', 2, '/api/manage/organize/detail', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (57, 54, 'ORGANIZE_MANAGE_CREATE', '新建组织', 1, '/api/manage/organize/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (58, 54, 'ORGANIZE_MANAGE_UPDATE', '修改组织', 1, '/api/manage/organize/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (59, 54, 'ORGANIZE_MANAGE_DELETE', '删除组织', 1, '/api/manage/organize/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (60, 54, 'ORGANIZE_MANAGE_TREE', '组织完整树', 2, '/api/manage/organize/tree', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (61, 2, 'DICT_MANAGE', '数据字典', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (62, 61, 'DICT_MANAGE_LAZYTREE', '数据字典懒加载树', 2, '/api/manage/dict/lazyTree', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (63, 61, 'DICT_MANAGE_DETAIL', '数据字典详情', 2, '/api/manage/dict/detail', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (64, 61, 'DICT_MANAGE_CREATE', '新建字典', 1, '/api/manage/dict/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (65, 61, 'DICT_MANAGE_UPDATE', '修改字典', 1, '/api/manage/dict/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (66, 61, 'DICT_MANAGE_DELETE', '删除字典', 1, '/api/manage/dict/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (67, 0, 'ARTICLE_MANAGE', '文档管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (68, 67, 'ARTICLE_MANAGE_LIST', '文档列表', 2, '/api/manage/article/list', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (70, 67, 'ARTICLE_MANAGE_CREATE', '新建文档', 1, '/api/manage/article/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (71, 67, 'ARTICLE_MANAGE_UPDATE', '修改文档', 1, '/api/manage/article/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (72, 67, 'ARTICLE_MANAGE_DELETE', '删除文档', 1, '/api/manage/article/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (73, 91, 'MERCHANT_USER_MANAGE', '商户操作员管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (74, 73, 'MERCHANT_USER_LIST', '商户操作员列表', 2, '/api/manage/merchant-user/list', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (75, 73, 'MERCHANT_USER_ADD', '新建商户操作员', 1, '/api/manage/merchant-user/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (76, 73, 'MERCHANT_USER_UPDATE', '修改商户操作员', 1, '/api/manage/merchant-user/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (77, 73, 'MERCHANT_USER_ENABLE', '商户操作员启用', 1, '/api/manage/merchant-user/enable', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (78, 73, 'MERCHANT_USER_DISABLE', '商户操作员禁用', 1, '/api/manage/merchant-user/disable', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (79, 73, 'MERCHANT_USER_DELETE', '删除商户操作员', 1, '/api/manage/merchant-user/delete', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (80, 73, 'MERCHANT_USER_GET2EDIT', '获取改商户操作员数据2修改', 2, '/api/manage/merchant-user/get2Edit', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (81, 73, 'MERCHANT_USER_RESET_PWD', '商户操作员重置登录密码', 1, '/api/manage/merchant-user/resetPassword', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (82, 0, 'PLATFORM_INFO_MANAGE', '服务平台信息管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (83, 82, 'PLATFORM_INFO_LIST', '服务平台列表', 2, '/api/manage/service-platform/list', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (84, 82, 'PLATFORM_INFO_UPDATE', '修改服务平台信息', 1, '/api/manage/service-platform/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (85, 82, 'PLATFORM_INFO_GET', '服务平台GET', 2, '/api/manage/service-platform/get', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (86, 91, 'MERCHANT_INFO_MANAGE', '商户信息管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (87, 86, 'MERCHANT_INFO_LIST', '商户列表', 2, '/api/manage/merchant/list', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (88, 86, 'MERCHANT_INFO_ADD', '新建商户', 1, '/api/manage/merchant/create', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (89, 86, 'MERCHANT_INFO_UPDATE', '修改商户', 1, '/api/manage/merchant/update', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (90, 86, 'MERCHANT_INFO_GET', '商户GET', 1, '/api/manage/merchant/get', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (91, 0, 'MERCHANT_MANAGE', '商户管理', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (92, 91, 'MERCHANT_RATE_CONFIG', '费率配置', 0, '', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (93, 91, 'RATE_CONFIG_SUBMIT', '费率配置提交', 1, '/api/manage/merchant/rate-config', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (94, 91, 'GET_CONTRACT_LIST', '合同照片列表', 1, '/api/manage/merchant/contract-list', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');
INSERT INTO `menu` VALUES (95, 91, 'UPLOAD_CONTRACT', '上传合同照片', 1, '/api/manage/merchant/upload-contract', b'0', '2020-07-31 18:24:45', '2020-07-31 18:24:45');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色编码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `describe` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '描述',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ADMIN', '系统管理员', '系统管理员', b'0');
INSERT INTO `role` VALUES (2, 'OPERATE', '运营', '运营人员', b'0');
INSERT INTO `role` VALUES (3, 'EMP', '员工', '普通员工asfsdfasdfasdf', b'1');
INSERT INTO `role` VALUES (4, 'EMP', '员工', '普通员工', b'1');
INSERT INTO `role` VALUES (5, 'TEST', '测试11111', '测试12121212', b'1');
INSERT INTO `role` VALUES (6, 'DEV', '开发', '开发人员', b'1');
INSERT INTO `role` VALUES (7, 'DEV', '开发', '开发人员', b'1');
INSERT INTO `role` VALUES (8, 'SCM', 'SCM', 'aasdfasdfasdf', b'1');
INSERT INTO `role` VALUES (9, 'TEST', '测试', '测试描述', b'0');
INSERT INTO `role` VALUES (10, '', '', '', b'1');
INSERT INTO `role` VALUES (11, 'adsddddde', 'test1111', 'abcdefg', b'1');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  `menu_id` int(11) NOT NULL DEFAULT 0 COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 9, 2);
INSERT INTO `role_menu` VALUES (2, 9, 5);
INSERT INTO `role_menu` VALUES (3, 9, 20);
INSERT INTO `role_menu` VALUES (4, 9, 21);
INSERT INTO `role_menu` VALUES (5, 9, 22);
INSERT INTO `role_menu` VALUES (6, 9, 23);
INSERT INTO `role_menu` VALUES (7, 9, 24);
INSERT INTO `role_menu` VALUES (8, 9, 25);
INSERT INTO `role_menu` VALUES (9, 2, 1);
INSERT INTO `role_menu` VALUES (10, 2, 2);
INSERT INTO `role_menu` VALUES (11, 2, 5);
INSERT INTO `role_menu` VALUES (12, 2, 20);
INSERT INTO `role_menu` VALUES (13, 2, 21);
INSERT INTO `role_menu` VALUES (14, 2, 22);
INSERT INTO `role_menu` VALUES (15, 2, 23);
INSERT INTO `role_menu` VALUES (16, 2, 24);
INSERT INTO `role_menu` VALUES (17, 2, 25);
INSERT INTO `role_menu` VALUES (18, 1, 1);
INSERT INTO `role_menu` VALUES (19, 1, 2);
INSERT INTO `role_menu` VALUES (20, 1, 3);
INSERT INTO `role_menu` VALUES (21, 1, 6);
INSERT INTO `role_menu` VALUES (22, 1, 7);
INSERT INTO `role_menu` VALUES (23, 1, 8);
INSERT INTO `role_menu` VALUES (24, 1, 14);
INSERT INTO `role_menu` VALUES (25, 1, 27);
INSERT INTO `role_menu` VALUES (26, 1, 4);
INSERT INTO `role_menu` VALUES (27, 1, 15);
INSERT INTO `role_menu` VALUES (28, 1, 16);
INSERT INTO `role_menu` VALUES (29, 1, 17);
INSERT INTO `role_menu` VALUES (30, 1, 18);
INSERT INTO `role_menu` VALUES (31, 1, 19);
INSERT INTO `role_menu` VALUES (32, 1, 5);
INSERT INTO `role_menu` VALUES (33, 1, 20);
INSERT INTO `role_menu` VALUES (34, 1, 21);
INSERT INTO `role_menu` VALUES (35, 1, 22);
INSERT INTO `role_menu` VALUES (36, 1, 23);
INSERT INTO `role_menu` VALUES (37, 1, 24);
INSERT INTO `role_menu` VALUES (38, 1, 25);
INSERT INTO `role_menu` VALUES (39, 1, 26);
INSERT INTO `role_menu` VALUES (40, 1, 48);
INSERT INTO `role_menu` VALUES (41, 1, 49);
INSERT INTO `role_menu` VALUES (42, 1, 50);
INSERT INTO `role_menu` VALUES (43, 1, 51);
INSERT INTO `role_menu` VALUES (44, 1, 52);
INSERT INTO `role_menu` VALUES (45, 1, 53);
INSERT INTO `role_menu` VALUES (46, 1, 54);
INSERT INTO `role_menu` VALUES (47, 1, 55);
INSERT INTO `role_menu` VALUES (48, 1, 56);
INSERT INTO `role_menu` VALUES (49, 1, 57);
INSERT INTO `role_menu` VALUES (50, 1, 58);
INSERT INTO `role_menu` VALUES (51, 1, 59);
INSERT INTO `role_menu` VALUES (52, 1, 60);
INSERT INTO `role_menu` VALUES (53, 1, 61);
INSERT INTO `role_menu` VALUES (54, 1, 62);
INSERT INTO `role_menu` VALUES (55, 1, 63);
INSERT INTO `role_menu` VALUES (56, 1, 64);
INSERT INTO `role_menu` VALUES (57, 1, 65);
INSERT INTO `role_menu` VALUES (58, 1, 66);
INSERT INTO `role_menu` VALUES (59, 1, 67);
INSERT INTO `role_menu` VALUES (60, 1, 68);
INSERT INTO `role_menu` VALUES (61, 1, 70);
INSERT INTO `role_menu` VALUES (62, 1, 71);
INSERT INTO `role_menu` VALUES (63, 1, 72);
INSERT INTO `role_menu` VALUES (64, 1, 82);
INSERT INTO `role_menu` VALUES (65, 1, 83);
INSERT INTO `role_menu` VALUES (66, 1, 84);
INSERT INTO `role_menu` VALUES (67, 1, 85);
INSERT INTO `role_menu` VALUES (68, 1, 91);
INSERT INTO `role_menu` VALUES (69, 1, 73);
INSERT INTO `role_menu` VALUES (70, 1, 74);
INSERT INTO `role_menu` VALUES (71, 1, 75);
INSERT INTO `role_menu` VALUES (72, 1, 76);
INSERT INTO `role_menu` VALUES (73, 1, 77);
INSERT INTO `role_menu` VALUES (74, 1, 78);
INSERT INTO `role_menu` VALUES (75, 1, 79);
INSERT INTO `role_menu` VALUES (76, 1, 80);
INSERT INTO `role_menu` VALUES (77, 1, 81);
INSERT INTO `role_menu` VALUES (78, 1, 86);
INSERT INTO `role_menu` VALUES (79, 1, 87);
INSERT INTO `role_menu` VALUES (80, 1, 88);
INSERT INTO `role_menu` VALUES (81, 1, 89);
INSERT INTO `role_menu` VALUES (82, 1, 90);
INSERT INTO `role_menu` VALUES (83, 1, 92);
INSERT INTO `role_menu` VALUES (84, 1, 93);
INSERT INTO `role_menu` VALUES (85, 1, 94);
INSERT INTO `role_menu` VALUES (86, 1, 95);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `id_card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '身份证号',
  `position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '职位',
  `department` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门',
  `organization_id` int(11) NOT NULL DEFAULT 0 COMMENT '所属组织',
  `organization_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '所属组织名称',
  `state` int(11) NOT NULL DEFAULT 1 COMMENT '状态（0停用,1启用,2删除）',
  `type` int(11) NOT NULL DEFAULT 2 COMMENT '账号类型（0：超级管理员，1：管理员，2：普通账号）',
  `salt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '盐加密',
  `remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '13900000001', '超级管理员', '8a59bba2559534b4d0dd0f546091d677', '330327199005224278', '前端', '基础部门', 1, '三墩支行', 1, 0, '701574', '', '2020-08-18 16:44:21', '2020-09-02 11:55:43');
INSERT INTO `user` VALUES (2, '13900000002', '三墩管理员', 'f131deaa0f01f3cef67e3ff783729f7a', '330327199005224278', '行长', '行长办公室', 1, '三墩支行', 0, 1, '280703', '', '2020-08-19 15:43:39', '2020-09-02 11:55:38');
INSERT INTO `user` VALUES (3, '15958723720', '黄雪冬', '8a4e5c38988131d978d699b5eedc1b02', '33030319890121091X', '测试', '1', 1, '三墩支行', 0, 2, '128563', '1', '2020-08-28 14:55:24', '2020-09-04 09:55:27');
INSERT INTO `user` VALUES (4, '15958723720', '黄雪冬', '8321cad100481a4b05ff3571d7f4b71d', '330303198901010101', '测试', '测试', 1, '三墩支行', 2, 2, '791001', '测试', '2020-08-31 18:15:37', '2020-09-01 11:22:19');
INSERT INTO `user` VALUES (5, '13754322565', '拱墅管理员', '1be49e08aa0a5dbe6fb9054f047b1d2c', '330327199005224278', '运维', '技术部', 1, '三墩支行', 1, 1, '675750', '测试', '2020-09-04 09:56:57', '2020-09-04 09:56:57');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 9);
INSERT INTO `user_role` VALUES (3, 4, 9);
INSERT INTO `user_role` VALUES (4, 4, 2);

-- ----------------------------
-- Table structure for worker_node
-- ----------------------------
DROP TABLE IF EXISTS `worker_node`;
CREATE TABLE `worker_node`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `HOST_NAME` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'host name',
  `PORT` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'port',
  `TYPE` int(11) NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
  `LAUNCH_DATE` date NOT NULL COMMENT 'launch date',
  `MODIFIED` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'modified time',
  `CREATED` timestamp(0) NOT NULL COMMENT 'created time',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'DB WorkerID Assigner for UID Generator' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of worker_node
-- ----------------------------
INSERT INTO `worker_node` VALUES (1, '192.168.131.222', '1597743193822-6702', 2, '2020-08-18', '2020-08-18 17:33:13', '2020-08-18 17:33:13');
INSERT INTO `worker_node` VALUES (2, '192.168.131.222', '1597743372894-20109', 2, '2020-08-18', '2020-08-18 17:36:12', '2020-08-18 17:36:12');
INSERT INTO `worker_node` VALUES (3, '192.168.131.222', '1597743707131-85878', 2, '2020-08-18', '2020-08-18 17:41:47', '2020-08-18 17:41:47');
INSERT INTO `worker_node` VALUES (4, '192.168.0.105', '1598279918057-46349', 2, '2020-08-24', '2020-08-24 22:38:38', '2020-08-24 22:38:38');
INSERT INTO `worker_node` VALUES (5, '192.168.0.105', '1598280951389-83626', 2, '2020-08-24', '2020-08-24 22:55:51', '2020-08-24 22:55:51');
INSERT INTO `worker_node` VALUES (6, '192.168.0.105', '1598281293708-53457', 2, '2020-08-24', '2020-08-24 23:01:33', '2020-08-24 23:01:33');
INSERT INTO `worker_node` VALUES (7, '192.168.0.105', '1598282542891-82989', 2, '2020-08-24', '2020-08-24 23:22:22', '2020-08-24 23:22:22');
INSERT INTO `worker_node` VALUES (8, '192.168.0.105', '1598285950319-16634', 2, '2020-08-25', '2020-08-25 00:19:10', '2020-08-25 00:19:10');
INSERT INTO `worker_node` VALUES (9, '192.168.131.222', '1598329604702-40120', 2, '2020-08-25', '2020-08-25 12:26:44', '2020-08-25 12:26:44');
INSERT INTO `worker_node` VALUES (10, '192.168.131.222', '1598331185852-89826', 2, '2020-08-25', '2020-08-25 12:53:05', '2020-08-25 12:53:05');
INSERT INTO `worker_node` VALUES (11, '192.168.131.222', '1598435297775-48764', 2, '2020-08-26', '2020-08-26 17:48:18', '2020-08-26 17:48:18');
INSERT INTO `worker_node` VALUES (12, '192.168.131.222', '1598506794035-70997', 2, '2020-08-27', '2020-08-27 13:39:54', '2020-08-27 13:39:54');
INSERT INTO `worker_node` VALUES (13, '192.168.131.222', '1598522063548-64364', 2, '2020-08-27', '2020-08-27 17:54:23', '2020-08-27 17:54:23');
INSERT INTO `worker_node` VALUES (14, '192.168.131.222', '1598523701155-39947', 2, '2020-08-27', '2020-08-27 18:21:41', '2020-08-27 18:21:41');
INSERT INTO `worker_node` VALUES (15, '192.168.131.222', '1598523769107-54027', 2, '2020-08-27', '2020-08-27 18:22:49', '2020-08-27 18:22:49');
INSERT INTO `worker_node` VALUES (16, '192.168.131.222', '1598524401488-46386', 2, '2020-08-27', '2020-08-27 18:33:21', '2020-08-27 18:33:21');
INSERT INTO `worker_node` VALUES (17, '192.168.0.105', '1598537025994-15926', 2, '2020-08-27', '2020-08-27 22:03:46', '2020-08-27 22:03:46');
INSERT INTO `worker_node` VALUES (18, '192.168.0.105', '1598542467434-74218', 2, '2020-08-27', '2020-08-27 23:34:27', '2020-08-27 23:34:27');
INSERT INTO `worker_node` VALUES (19, '192.168.131.222', '1598603762012-49193', 2, '2020-08-28', '2020-08-28 16:36:02', '2020-08-28 16:36:02');
INSERT INTO `worker_node` VALUES (20, '192.168.0.105', '1598625676204-87289', 2, '2020-08-28', '2020-08-28 22:41:16', '2020-08-28 22:41:16');
INSERT INTO `worker_node` VALUES (21, '240e:390:62d:f1b1:6083:34b5:9ff7:2', '1599285251856-37730', 2, '2020-09-05', '2020-09-05 13:54:12', '2020-09-05 13:54:12');

SET FOREIGN_KEY_CHECKS = 1;
