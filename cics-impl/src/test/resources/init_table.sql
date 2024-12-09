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
    `ywrq`              datetime        not null,
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
    unique key ( `zmxdocNo`),
    key (`ywrq`)
) engine=innodb default charset=utf8;

create table if not exists `guidaoheng_detail` (
    `id`                bigint              not null    auto_increment comment '主键',
    `zmxdocNo`          varchar(100)        not null,
    `dtSortno`          varchar(100),
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
    `ywrq`              datetime        not null,
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
    unique key ( `zmxdocNo`),
    key ( `ywrq`)
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
    `ywrq`              datetime        not null,
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
    unique key ( `mybs`),
    key (`ywrq`)
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



create table if not exists `pidaimeicaiyang` (
    `id`                         bigint          not null    auto_increment comment '主键',
    `ywrq`              datetime        not null,
    `mybs`                       varchar(100)    not null,
    `ssejdw`                     varchar(100),
    `ssejdwid`                   varchar(100),
    `sssjdw`                     varchar(100),
    `sssjdwid`                   varchar(100),
    `cypml`                      decimal(20,5),
    `cydysl`                     int,
    `sjyxt`                      varchar(100),
    `sjtsdanwei`                 varchar(100),
    `xtscjlI`                    varchar(100),
    `xtscjlT`                    varchar(100),
    `sjscfs`                     varchar(100),
    `byzd1`                      varchar(100),
    `byzd2`                      varchar(100),
    `byzd3`                      varchar(100),
    `byzd4`                      varchar(100),
    `byzd5`                      varchar(100),
    `byzd6`                      varchar(100),
    `byzd7`                      varchar(100),
    `byzd8`                      varchar(100),
    `byzd9`                      varchar(100),
    `byzd10`                     varchar(100),
    `status`            tinyint         not null    comment '上报状态：0 - 未上报；1 - 上报成功; 2 - 上报失败',
    `upload_time`       datetime        comment '上报时间',
    `operator`          varchar(100)    comment '上报人',
    primary key ( `id` ),
    unique key ( `mybs`),
    key (`ywrq`)
) engine=innodb default charset=utf8;


create table if not exists `pidaimeicaiyang_detail` (
    `id`                         bigint              not null    auto_increment comment '主键',
    `mybs`                       varchar(100)        not null,
    `dtCydyxh`                   int,
    `dtCysbbm`                   varchar(100),
    `dtCyfs`                     varchar(100),
    `dtCydybm`                   varchar(100),
    `dtCysdate`                  varchar(100),
    `dtCystime`                  varchar(100),
    `dtCyedate`                  varchar(100),
    `dtCyetime`                  varchar(100),
    `dtCysbmc`                   varchar(100),
    `dtCysbid`                   varchar(100),
    `dtCydyml`                   decimal(20,5),
    `dtCyjgsj`                   varchar(100),
    `dtCjzyl`                    decimal(20,5),
    `dtYijisfsj`                 int,
    `dtYijisfjg`                 int,
    `dtYijisfcysj`               int,
    `dtYijisfcs`                 int,
    `dtErjisfsj`                 int,
    `dtErjisfjg`                 int,
    `dtErjisfcysj`               int,
    `dtErjisfcs`                 int,
    `dtCyzl`                     decimal(20,5),
    `dtLytongshu`                int,
    `dtYlzl`                     decimal(20,5),
    `dtCydyreserve1`             varchar(100),
    `dtCydyreserve2`             varchar(100),
    `dtCydyreserve3`             varchar(100),
    `dtCydyreserve4`             varchar(100),
    `dtCydyreserve5`             varchar(100),
    primary key ( `id` ),
    key ( `mybs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table if not exists `meizhi` (
    `id`                         bigint          not null    auto_increment comment '主键',
    `ywrq`                       datetime        not null,
    `mybs`                       varchar(100)    not null,
    `ssejdw`                     varchar(100),
    `ssejdwid`                   varchar(100),
    `sssjdw`                     varchar(100),
    `sssjdwid`                   varchar(100),
    `hypml`                      decimal(20,5),
    `meizhong`                   varchar(100),
    `meizhongbm`                 varchar(100),
    `hyorgname`                  varchar(100),
    `jiancefangshi`              varchar(100),
    `jiancesbmc`                 varchar(100),
    `jiancesbid`                 varchar(100),
    `assayI`                     varchar(100),
    `assayT`                     varchar(100),
    `ngymt`                      decimal(20,5),
    `ngymad`                     decimal(20,5),
    `nlcfaar`                    decimal(20,5),
    `ngyaad`                     decimal(20,5),
    `nlcfad`                     decimal(20,5),
    `nlcfvar`                    decimal(20,5),
    `ngyvad`                     decimal(20,5),
    `nlcfvd`                     decimal(20,5),
    `ngyvdaf`                    decimal(20,5),
    `nlcfstar`                   decimal(20,5),
    `nlcfstad`                   decimal(20,5),
    `nlcfstd`                    decimal(20,5),
    `nqgrdmj`                    decimal(20,5),
    `nqnetarmj`                  decimal(20,5),
    `nqnetmarkc`                 decimal(20,5),
    `nqbadmj`                    decimal(20,5),
    `nqgradmj`                   decimal(20,5),
    `nqgradkc`                   decimal(20,5),
    `nqgrdkc`                    decimal(20,5),
    `nqgrarmj`                   decimal(20,5),
    `bondindex`                  decimal(20,5),
    `nhrDt`                      varchar(100),
    `nhrSt`                      varchar(100),
    `nhrHt`                      varchar(100),
    `nhrFt`                      varchar(100),
    `nymqcrc`                    int,
    `nyshar`                     decimal(20,5),
    `nyshad`                     decimal(20,5),
    `nyshd`                      decimal(20,5),
    `nyhdaf`                     decimal(20,5),
    `nyscad`                     decimal(20,5),
    `nyscd`                      decimal(20,5),
    `nycdaf`                     decimal(20,5),
    `hgi`                        decimal(20,5),
    `nysfcad`                    decimal(20,5),
    `nyshfcd`                    decimal(20,5),
    `mhcfAlo`                    decimal(20,5),
    `mhcfCao`                    decimal(20,5),
    `mhcfMgo`                    decimal(20,5),
    `mhcfSo`                     decimal(20,5),
    `mhcfTio`                    decimal(20,5),
    `mhcfPo`                     decimal(20,5),
    `mhcfKo`                     decimal(20,5),
    `mhcfNao`                    decimal(20,5),
    `mhcfSio`                    decimal(20,5),
    `mhcfFeo`                    decimal(20,5),
    `zcdanhao`                   varchar(100),
    `xiecheid`                   varchar(100),
    `loadStartNo`                varchar(100),
    `loadEndNo`                  varchar(100),
    `bzId`                       varchar(100),
    `status`                     varchar(100),
    `kuaimanhui`                 varchar(100),
    `wtdh`                       varchar(100),
    `czrq`                       varchar(100),
    `zsbh`                       varchar(100),
    `beizhu`                     varchar(100),
    `sjtsdanwei`                 varchar(100),
    `xtscjlI`                    varchar(100),
    `xtscjlT`                    varchar(100),
    `byzd1`                      varchar(100),
    `byzd2`                      varchar(100),
    `byzd3`                      varchar(100),
    `byzd4`                      varchar(100),
    `byzd5`                      varchar(100),
    `hydsl`                      varchar(100),
    `upload_status`            tinyint         not null    comment '上报状态：0 - 未上报；1 - 上报成功; 2 - 上报失败',
    `upload_time`       datetime        comment '上报时间',
    `operator`          varchar(100)    comment '上报人',
    primary key ( `id` ),
    unique key ( `mybs`),
    key (`ywrq`)
) engine=innodb default charset=utf8;


create table if not exists `meizhi_detail` (
    `id`                         bigint              not null    auto_increment comment '主键',
    `mybs`                       varchar(100)        not null,
    `dtHyd1id`                   varchar(100),
    `dtHyd2id`                   varchar(100),
    `dtHyd3id`                   varchar(100),
    `dtHyd4id`                   varchar(100),
    `dtHyd5id`                   varchar(100),
    `dtHyd6id`                   varchar(100),
    `dtHyd7id`                   varchar(100),
    `dtHyd8id`                   varchar(100),
    primary key ( `id` ),
    unique key ( `mybs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table if not exists `huayandan` (
    `id`                         bigint          not null    auto_increment comment '主键',
    `ywrq`                       datetime        not null,
    `mybs`                       varchar(100)    not null,
    `dtHydid`                    varchar(100),
    `dtHydxh`                    varchar(100),
    `ssejdw`                     varchar(100),
    `ssejdwid`                   varchar(100),
    `sssjdw`                     varchar(100),
    `sssjdwid`                   varchar(100),
    `hyorgname`                  varchar(100),
    `sampeldate`                 varchar(100),
    `sampleid`                   varchar(100),
    `assayid`                    varchar(100),
    `jiancejieguoyt`             varchar(100),
    `jiancefangshi`              varchar(100),
    `jiancesbmc`                 varchar(100),
    `jiancesbid`                 varchar(100),
    `meizhong`                   varchar(100),
    `meizhongbm`                 varchar(100),
    `dtAssayI`                   varchar(100),
    `dtAssayT`                   varchar(100),
    `dtDuiyingml`                decimal(20,5),
    `dtNgymt`                    decimal(20,5),
    `dtNgymad`                   decimal(20,5),
    `dtNlcfaar`                  decimal(20,5),
    `dtNgyaad`                   decimal(20,5),
    `dtNlcfad`                   decimal(20,5),
    `dtNlcfvar`                  decimal(20,5),
    `dtNgyvad`                   decimal(20,5),
    `dtNlcfvd`                   decimal(20,5),
    `dtNgyvdaf`                  decimal(20,5),
    `dtNlcfstar`                 decimal(20,5),
    `dtNlcfstad`                 decimal(20,5),
    `dtNlcfstd`                  decimal(20,5),
    `dtNqgrdmj`                  decimal(20,5),
    `dtNqnetarmj`                decimal(20,5),
    `dtNqnetmarkc`               decimal(20,5),
    `dtNqbadmj`                  decimal(20,5),
    `dtNqgradmj`                 decimal(20,5),
    `dtNqgradkc`                 decimal(20,5),
    `dtNqgrdkc`                  decimal(20,5),
    `dtNqgrarmj`                 decimal(20,5),
    `dtBondindex`                decimal(20,5),
    `dtNhrdt`                    decimal(20,5),
    `dtNhrst`                    decimal(20,5),
    `dtNhrht`                    decimal(20,5),
    `dtNhrft`                    decimal(20,5),
    `dtNymqcrc`                  int,
    `dtNyshar`                   decimal(20,5),
    `dtNyshad`                   decimal(20,5),
    `dtNyshd`                    decimal(20,5),
    `dtNyhdaf`                   decimal(20,5),
    `dtNyscad`                   decimal(20,5),
    `dtNyscd`                    decimal(20,5),
    `dtNycdaf`                   decimal(20,5),
    `dtHgi`                      decimal(20,5),
    `dtNysfcad`                  decimal(20,5),
    `dtNyshfcd`                  decimal(20,5),
    `dtKuaimanhui`               varchar(100),
    `sjtsdanwei`                 varchar(100),
    `xtscjlI`                    varchar(100),
    `xtscjlT`                    varchar(100),
    `byzd1`                      varchar(100),
    `byzd2`                      varchar(100),
    `byzd3`                      varchar(100),
    `byzd4`                      varchar(100),
    `byzd5`                      varchar(100),
    `status`            tinyint         not null    comment '上报状态：0 - 未上报；1 - 上报成功; 2 - 上报失败',
    `upload_time`       datetime        comment '上报时间',
    `operator`          varchar(100)    comment '上报人',
    primary key ( `id` ),
    unique key ( `mybs`),
    key (`ywrq`)
) engine=innodb default charset=utf8;


create table if not exists `kjhuayandan` (
    `id`                         bigint          not null    auto_increment comment '主键',
    `ywrq`                       datetime        not null,
    `mybs`                       varchar(100)    not null,
    `sssjdwid`                   varchar(100),
    `dtHydid`                    varchar(100),
    `dtHydxh`                    varchar(100),
    `hyorgname`                  varchar(100),
    `sampeldate`                 varchar(100),
    `sampleid`                   varchar(100),
    `assayid`                    varchar(100),
    `jiancejieguoyt`             varchar(100),
    `jiancefangshi`              varchar(100),
    `sjscfs`                     varchar(100),
    `jiancesbmc`                 varchar(100),
    `jiancesbid`                 varchar(100),
    `meizhong`                   varchar(100),
    `meizhongbm`                 varchar(100),
    `dtAssayI`                   varchar(100),
    `dtAssayT`                   varchar(100),
    `dtDuiyingml`                varchar(100),
    `version`                    varchar(100),
    `equipmentId`                varchar(100),
    `infoCount`                  int,
    `scanNumber`                 varchar(100),
    `onLineStatus`               varchar(100),
    `indexUuid`                  varchar(100),
    `coalName`                   varchar(100),
    `trainNumber`                varchar(100),
    `loadNumber`                 varchar(100),
    `loadSite`                   varchar(100),
    `firstNumber`                varchar(100),
    `tailNumber`                 varchar(100),
    `loadTime`                   varchar(100),
    `avglowHeatValueMj`          varchar(100),
    `avghighHeatValueMj`         varchar(100),
    `avglowHeatValueKcal`        varchar(100),
    `avghighHeatValueKcal`       varchar(100),
    `avgashContent`              varchar(100),
    `avgsulfurContent`           varchar(100),
    `avgfullyWash`               varchar(100),
    `avgashMeltingPoint`         varchar(100),
    `avgcarbonContent`           varchar(100),
    `avghydrogenContent`         varchar(100),
    `avgvolatileMatter`          varchar(100),
    `avgfixedCarbon`             varchar(100),
    `avgharmfulElementCI`        varchar(100),
    `avgharmfulElementP`         varchar(100),
    `avgDryVolatileMatter`       varchar(100),
    `avgDeformationTemp`         varchar(100),
    `avgSofteningTemp`           varchar(100),
    `avgHemisphereTemp`          varchar(100),
    `avgFlowTemp`                varchar(100),
    `singleIndex`                varchar(100),
    `singlelowHeatValueMj`       varchar(100),
    `singlehighHeatValueMj`      varchar(100),
    `singlelowHeatValueKcal`     varchar(100),
    `singlehighHeatValueKcal`    varchar(100),
    `singleashContent`           varchar(100),
    `singlesulfurContent`        varchar(100),
    `singlefullyWash`            varchar(100),
    `singleashMeltingPoint`      varchar(100),
    `singlecarbonContent`        varchar(100),
    `singlehydrogenContent`      varchar(100),
    `singlevolatileMatter`       varchar(100),
    `singllefixedCarbon`         varchar(100),
    `singleharmfulElementCI`     varchar(100),
    `singleharmfulElementP`      varchar(100),
    `singleDryVolatileMatter`    varchar(100),
    `singleDeformationTemp`      varchar(100),
    `singleSofteningTemp`        varchar(100),
    `singleHemisphereTemp`       varchar(100),
    `singleFlowTemp`             varchar(100),
    `startTime`                  varchar(100),
    `finishTime`                 varchar(100),
    `volume`                     varchar(100),
    `algoModel`                  varchar(100),
    `algoModelUpdateTime`        varchar(100),
    `sampleParameter1`           varchar(100),
    `sampleParameter2`           varchar(100),
    `trainNumberStop`            varchar(100),
    `testSampleCount`            varchar(100),
    `reserve1`                   varchar(100),
    `reserve2`                   varchar(100),
    `reserve3`                   varchar(100),
    `reserve4`                   varchar(100),
    `reserve5`                   varchar(100),
    `reserve6`                   varchar(100),
    `reserve7`                   varchar(100),
    `status`            tinyint         not null    comment '上报状态：0 - 未上报；1 - 上报成功; 2 - 上报失败',
    `upload_time`       datetime        comment '上报时间',
    `operator`          varchar(100)    comment '上报人',
    primary key ( `id` ),
    unique key ( `mybs`),
    key (`ywrq`)
) engine=innodb default charset=utf8;