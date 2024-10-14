create table if not exists `user_profile` (
    `id`        bigint      not null    auto_increment comment '主键',
    `username`  varchar(32) not null    comment '登录账号',
    `password`  varchar(32) not null    comment '密码',
    primary key ( `id` ),
    unique key ( `username` )
) engine=innodb default charset=utf8;

create table if not exists `employee` (
    `id`                bigint          not null    auto_increment comment '主键',
    `phone`             varchar(32)     not null    comment '电话',
    `employee_name`     varchar(32)     not null    comment '姓名',
    `department`        varchar(32)     not null    comment '部门',
    `salary`            bigint          not null    comment '薪水',
    primary key ( `id` ),
    unique key ( `phone` ),
    key (`department`)
) engine=innodb default charset=utf8;

create table if not exists `upload_status` (
    `id`                bigint          not null    auto_increment comment '主键',
    `doctype`           tinyint         not null    comment '文档类型',
    `docno`             varchar(100)    not null    comment '文档编号',
    `status`            tinyint         not null    comment '上报状态：0 - 上报错误；1 - 上报成功',
    primary key ( `id` ),
    unique key ( `doctype`, `docno` )
) engine=innodb default charset=utf8;

--create table if not exists `guidaoheng` (
--    `zmxdocno` VARCHAR(100) NOT NULL DEFAULT '',
--    `ssejdw` VARCHAR(100) NOT NULL DEFAULT '',
--    `ssejdwid` VARCHAR(100) NOT NULL DEFAULT '',
--    `sssjdw` VARCHAR(100) NOT NULL DEFAULT '',
--    `sssjdwid` VARCHAR(100) NOT NULL DEFAULT '',
--    `zczhandian` VARCHAR(100) NOT NULL DEFAULT '',
--    `zczhandianbm` VARCHAR(100) NOT NULL DEFAULT '',
--    `zccheci` VARCHAR(100) NOT NULL DEFAULT '',
--    `chexing` VARCHAR(100) NOT NULL DEFAULT '',
--    `mykuangdianmc` VARCHAR(100) NOT NULL DEFAULT '',
--    `mykuangdianbm` VARCHAR(100) NOT NULL DEFAULT '',
--    `meitanlaiyuan` VARCHAR(100) NOT NULL DEFAULT '',
--    `meitanlaiyuanbm` VARCHAR(100) NOT NULL DEFAULT '',
--    `zname1` VARCHAR(100) NOT NULL DEFAULT '',
--    `zkunnr` VARCHAR(100) NOT NULL DEFAULT '',
--    `vtext` VARCHAR(100) NOT NULL DEFAULT '',
--    `vkorg` VARCHAR(100) NOT NULL DEFAULT '',
--    `shouchehao` VARCHAR(100) NOT NULL DEFAULT '',
--    `weichehao` VARCHAR(100) NOT NULL DEFAULT '',
--    `cheshu` VARCHAR(100) NOT NULL DEFAULT '',
--    `jiliangdanwei` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongpiaozhong` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongmaozhong` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongpizhong` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongjingzhong` VARCHAR(100) NOT NULL DEFAULT '',
--    `koudunzongliang` VARCHAR(100) NOT NULL DEFAULT '',
--    `jiesuanmeiliang` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongyingkui` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongyingdun` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongkuidun` VARCHAR(100) NOT NULL DEFAULT '',
--    `zongyunsun` VARCHAR(100) NOT NULL DEFAULT '',
--    `duiweisj` VARCHAR(100) NOT NULL DEFAULT '',
--    `duiweirq` VARCHAR(100) NOT NULL DEFAULT '',
--    `yewurq` VARCHAR(100) NOT NULL DEFAULT '',
--    `zcmeizhong` VARCHAR(100) NOT NULL DEFAULT '',
--    `zcmeizhongbm` VARCHAR(100) NOT NULL DEFAULT '',
--    `wgmgys` VARCHAR(100) NOT NULL DEFAULT '',
--    `sjyxt` VARCHAR(100) NOT NULL DEFAULT '',
--    `cheyuan` VARCHAR(100) NOT NULL DEFAULT '',
--    `yundanhaoyundanhao` VARCHAR(100) NOT NULL DEFAULT '',
--    `jltypetype` VARCHAR(100) NOT NULL DEFAULT '',
--    `jlhqyt` VARCHAR(100) NOT NULL DEFAULT '',
--    `jlhqmc` VARCHAR(100) NOT NULL DEFAULT '',
--    `jlhqmcid` VARCHAR(100) NOT NULL DEFAULT '',
--    `daozhan` VARCHAR(100) NOT NULL DEFAULT '',
--    `fazhan` VARCHAR(100) NOT NULL DEFAULT '',
--    `zhongdao` VARCHAR(100) NOT NULL DEFAULT '',
--    `sjtsdanwei` VARCHAR(100) NOT NULL DEFAULT '',
--    `xtscjli` VARCHAR(100) NOT NULL DEFAULT '',
--    `xtscjlt` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd1` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd2` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd3` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd4` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd5` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd6` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd7` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd8` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd9` VARCHAR(100) NOT NULL DEFAULT '',
--    `byzd10` VARCHAR(100) NOT NULL DEFAULT ''
--) engine=innodb default charset=utf8;

CREATE TABLE IF NOT EXISTS guidaoheng (
    zmxdocNo VARCHAR(100) NOT NULL DEFAULT '',
    ssejdw VARCHAR(100) NOT NULL DEFAULT '',
    ssejdwid VARCHAR(100) NOT NULL DEFAULT '',
    sssjdw VARCHAR(100) NOT NULL DEFAULT '',
    sssjdwid VARCHAR(100) NOT NULL DEFAULT '',
    zccheci VARCHAR(100) NOT NULL DEFAULT '',
    chexing VARCHAR(100) NOT NULL DEFAULT '',
    mykuangdianmc VARCHAR(100) NOT NULL DEFAULT '',
    mykuangdianbm VARCHAR(100) NOT NULL DEFAULT '',
    shouchehao VARCHAR(100) NOT NULL DEFAULT '',
    weichehao VARCHAR(100) NOT NULL DEFAULT '',
    cheshu INT NOT NULL DEFAULT 0,  -- 通常对于整数类型，默认值为0更合适
    jiliangdanwei VARCHAR(100) NOT NULL DEFAULT '',
    zongpiaozhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000,  -- 对于decimal类型，提供一个具体的数值作为默认值
    zongmaozhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    zongpizhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    zongjingzhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    koudunzongliang DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    jiesuanmeiliang DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    zongyingkui DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    zongyingdun DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    zongyunsun DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    duiweisj TIME NOT NULL DEFAULT '00:00:00',  -- 为TIME类型提供一个合理的默认值
    duiweirq DATE NOT NULL DEFAULT '0000-00-00',  -- 或者使用'CURRENT_DATE'作为默认值，取决于您的需求
    yewurq DATE NOT NULL DEFAULT '0000-00-00',
    zcmeizhong VARCHAR(100) NOT NULL DEFAULT '',
    zcmeizhongbm VARCHAR(100) NOT NULL DEFAULT '',
    sjyxt VARCHAR(100) NOT NULL DEFAULT '',
    cheyuan VARCHAR(100) NOT NULL DEFAULT '',
    jltypetype VARCHAR(100) NOT NULL DEFAULT '',
    jlhqyt VARCHAR(100) NOT NULL DEFAULT '',
    jlhqmc VARCHAR(100) NOT NULL DEFAULT '',
    sjtsdanwei VARCHAR(100) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS guidaoheng_detail (
    zmxdocNo VARCHAR(100) NOT NULL DEFAULT '',
    dtSortno int NOT NULL,
    dtChehao VARCHAR(100) NOT NULL DEFAULT '',
    dtChexing VARCHAR(100) NOT NULL DEFAULT '',
    dtMaozhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    dtPizhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    dtJingzhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000,
    dtPiaozhong DECIMAL(20,5) NOT NULL DEFAULT 0.00000
) ENGINE=InnoDB DEFAULT CHARSET=utf8;