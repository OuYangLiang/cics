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

create table if not exists `guidaoheng` (
    `id`                bigint          not null    auto_increment comment '主键',
    `zmxdocNo`          varchar(100)    not null,
    `ssejdw`            varchar(100),
    `ssejdwid`          varchar(100),
    `sssjdw`            varchar(100),
    `sssjdwid`          varchar(100),
    `zczhandian`        varchar(100),
    `zczhandianbm`      varchar(100),
    `zccheci`           varchar(100),
    `chexing`           varchar(100),
    `mykuangdianmc`     varchar(100),
    `mykuangdianbm`     varchar(100),
    `meitanlaiyuan`     varchar(100),
    `meitanlaiyuanbm`   varchar(100),
    `zname1`            varchar(100),
    `zkunnr`            varchar(100),
    `vtext`             varchar(100),
    `vkorg`             varchar(100),
    `shouchehao`        varchar(100),
    `weichehao`         varchar(100),
    `cheshu`            int,
    `jiliangdanwei`     varchar(100),
    `zongpiaozhong`     decimal(20,5),
    `zongmaozhong`      decimal(20,5),
    `zongpizhong`       decimal(20,5),
    `zongjingzhong`     decimal(20,5),
    `koudunzongliang`   decimal(20,5),
    `jiesuanmeiliang`   decimal(20,5),
    `zongyingkui`       decimal(20,5),
    `zongyingdun`       decimal(20,5),
    `zongkuidun`        decimal(20,5),
    `zongyunsun`        decimal(20,5),
    `duiweisj`          varchar(100),
    `duiweirq`          varchar(100),
    `yewurq`            varchar(100),
    `zcmeizhong`        varchar(100),
    `zcmeizhongbm`      varchar(100),
    `wgmgys`            varchar(100),
    `sjyxt`             varchar(100),
    `cheyuan`           varchar(100),
    `yundanhaoyundanhao` varchar(100),
    `jltypetype`        varchar(100),
    `jlhqyt`            varchar(100),
    `jlhqmc`            varchar(100),
    `jlhqmcid`          varchar(100),
    `daozhan`           varchar(100),
    `fazhan`            varchar(100),
    `zhongdao`          varchar(100),
    `sjtsdanwei`        varchar(100),
    `xtscjlI`           varchar(100),
    `xtscjlT`           varchar(100),
    `byzd1`             varchar(100),
    `byzd2`             varchar(100),
    `byzd3`             varchar(100),
    `byzd4`             varchar(100),
    `byzd5`             varchar(100),
    `byzd6`             varchar(100),
    `byzd7`             varchar(100),
    `byzd8`             varchar(100),
    `byzd9`             varchar(100),
    `byzd10`            varchar(100),
    `status`            tinyint         not null    comment '上报状态：0 - 未上报；1 - 上报成功; 2 - 上报失败',
    `upload_time`       datetime        comment '上报时间',
    `operator`          varchar(100)    comment '上报人',
    primary key ( `id` ),
    unique key ( `zmxdocNo`)
) engine=innodb default charset=utf8;

create table if not exists `guidaoheng_detail` (
    `id`                bigint              not null    auto_increment comment '主键',
    `zmxdocNo`          varchar(100)        not null,
    `dtSortno`          varchar(100)        not null,
    `dtChehao`          varchar(100),
    `dtChexing`         varchar(100),
    `dtMaozhong`        decimal(20,5),
    `dtPizhong`         decimal(20,5),
    `dtJingzhong`       decimal(20,5),
    `dtBzdunshu`        decimal(20,5),
    `dtPiaozhong`       decimal(20,5),
    `dtYingdun`         decimal(20,5),
    `dtKuidun`          decimal(20,5),
    `dtYunsun`          decimal(20,5),
    `dtKoudun`          decimal(20,5),
    `dtCztime`          varchar(100),
    `dtCqtime`          varchar(100),
    `dtGhsudu`          decimal(20,5),
    `dtReserve1`        varchar(100),
    `dtReserve2`        varchar(100),
    `dtReserve3`        varchar(100),
    `dtReserve4`        varchar(100),
    `dtReserve5`        varchar(100),
    primary key ( `id` ),
    key ( `zmxdocNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists `qichecheng` (
    `id`                bigint          not null    auto_increment comment '主键',
    `zmxdocNo`          varchar(100)    not null,
    `ssejdw`            varchar(100),
    `ssejdwid`          varchar(100),
    `sssjdw`            varchar(100),
    `sssjdwid`          varchar(100),
    `zsitename`         varchar(100),
    `zsitebm`           varchar(100),
    `zname1`            varchar(100),
    `zkunnr`            varchar(100),
    `mykuangdianmc`     varchar(100),
    `mykuangdianbm`     varchar(100),
    `meitanlaiyuan`     varchar(100),
    `meitanlaiyuanbm`   varchar(100),
    `meizhong`          varchar(100),
    `meizhongbm`        varchar(100),
    `vtext`             varchar(100),
    `vkorg`             varchar(100),
    `zbeginI`           varchar(100),
    `zbeginT`           varchar(100),
    `zendI`             varchar(100),
    `zendT`             varchar(100),
    `zname1Car`         varchar(100),
    `zmeng`             decimal(20,5),
    `zmengpod`          decimal(20,5),
    `jiliangdanwei`     varchar(100),
    `zmasterNo`         varchar(100),
    `cheshu`            decimal(20,5),
    `zongpiaozhong`     decimal(20,5),
    `zongmaozhong`      decimal(20,5),
    `zongpizhong`       decimal(20,5),
    `zongjingzhong`     decimal(20,5),
    `zongyingkui`       decimal(20,5),
    `zongyingdun`       decimal(20,5),
    `zongkuidun`        decimal(20,5),
    `zongyunsun`        decimal(20,5),
    `koudunzongliang`   decimal(20,5),
    `jiesuanmeiliang`   decimal(20,5),
    `jlhqyt`            varchar(100),
    `kunnr`             varchar(100),
    `name1`             varchar(100),
    `zjhfs`             varchar(100),
    `sjtsdanwei`        varchar(100),
    `xtscjlI`           varchar(100),
    `xtscjlT`           varchar(100),
    `byzd1`             varchar(100),
    `byzd2`             varchar(100),
    `byzd3`             varchar(100),
    `byzd4`             varchar(100),
    `byzd5`             varchar(100),
    `byzd6`             varchar(100),
    `byzd7`             varchar(100),
    `byzd8`             varchar(100),
    `byzd9`             varchar(100),
    `byzd10`            varchar(100),
    `status`            tinyint         not null    comment '上报状态：0 - 未上报；1 - 上报成功; 2 - 上报失败',
    `upload_time`       datetime        comment '上报时间',
    `operator`          varchar(100)    comment '上报人',
    primary key ( `id` ),
    unique key ( `zmxdocNo`)
) engine=innodb default charset=utf8;

create table if not exists `qichecheng_detail` (
    `id`                bigint              not null    auto_increment comment '主键',
    `zmxdocNo`          varchar(100)        not null,
    `dtSortno`          varchar(100),
    `dtChepaihao`       varchar(100),
    `dtPiaozhong`       decimal(20,5),
    `dtMaozhong`        decimal(20,5),
    `dtPizhong`         decimal(20,5),
    `dtJingzhong`       decimal(20,5),
    `dtYingdun`         decimal(20,5),
    `dtKuidun`          decimal(20,5),
    `dtYunsun`          decimal(20,5),
    `dtKoudunl`         decimal(20,5),
    `dtJzdate`          varchar(100),
    `dtJztime`          varchar(100),
    `dtJqdate`          varchar(100),
    `dtJqtime`          varchar(100),
    `dtJzhmc`           varchar(100),
    `dtJzhid`           varchar(100),
    `dtJqhmc`           varchar(100),
    `dtJqhid`           varchar(100),
    `dtReserve1`        varchar(100),
    `dtReserve2`        varchar(100),
    `dtReserve3`        varchar(100),
    `dtReserve4`        varchar(100),
    `dtReserve5`        varchar(100),
    primary key ( `id` ),
    key ( `zmxdocNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



create table if not exists `meicaiyang` (
    `id`                bigint          not null    auto_increment comment '主键',
    `mybs`              varchar(100)    not null,
    `ssejdw`            varchar(100),
    `ssejdwid`          varchar(100),
    `sssjdw`            varchar(100),
    `sssjdwid`          varchar(100),
    `cypml`             decimal(20,5),
    `cydysl`            int,
    `sjyxt`             varchar(100),
    `sjtsdanwei`        varchar(100),
    `xtscjlI`           varchar(100),
    `xtscjlT`           varchar(100),
    `byzd1`             varchar(100),
    `byzd2`             varchar(100),
    `byzd3`             varchar(100),
    `byzd4`             varchar(100),
    `byzd5`             varchar(100),
    `byzd6`             varchar(100),
    `byzd7`             varchar(100),
    `byzd8`             varchar(100),
    `byzd9`             varchar(100),
    `byzd10`            varchar(100),
    `status`            tinyint         not null    comment '上报状态：0 - 未上报；1 - 上报成功; 2 - 上报失败',
    `upload_time`       datetime        comment '上报时间',
    `operator`          varchar(100)    comment '上报人',
    primary key ( `id` ),
    unique key ( `mybs`)
) engine=innodb default charset=utf8;

create table if not exists `meicaiyang_detail` (
    `id`                bigint              not null    auto_increment comment '主键',
    `mybs`              varchar(100)        not null,
    `dtCydyxh`          varchar(100),
    `dtCydybm`          varchar(100),
    `dtCyfs`            varchar(100),
    `dtCyquyu`          varchar(100),
    `dtCysdate`         varchar(100),
    `dtCystime`         varchar(100),
    `dtCyedate`         varchar(100),
    `dtCyetime`         varchar(100),
    `dtCysbmc`          varchar(100),
    `dtCysbid`          varchar(100),
    `dtCydyml`          decimal(20,5),
    `dtCydycs`          int,
    `dtCydyds`          int,
    `dtRengongcyzl`     decimal(20,5),
    `dtCysd`            varchar(100),
    `dtCjzyl`           decimal(20,5),
    `dtYijisfsj`        int,
    `dtYijisfjg`        int,
    `dtYijisfcysj`      int,
    `dtYijisfcs`        int,
    `dtErjisfsj`        int,
    `dtErjisfjg`        int,
    `dtErjisfcysj`      int,
    `dtErjisfcs`        int,
    `dtCyzl`            decimal(20,5),
    `dtLytonshu`        int,
    `dtLyzl`            decimal(20,5),
    `dtCydyreserve1`    varchar(100),
    `dtCydyreserve2`    varchar(100),
    `dtCydyreserve3`    varchar(100),
    `dtCydyreserve4`    varchar(100),
    `dtCydyreserve5`    varchar(100),
    primary key ( `id` ),
    key ( `mybs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



