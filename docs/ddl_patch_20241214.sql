
alter table `guidaoheng` add column `sjscfs` varchar(100) after `byzd10`;
alter table `guidaoheng` add column `appID` varchar(100) after `sjscfs`;

alter table `qichecheng` add column `sjscfs` varchar(100) after `byzd10`;
alter table `qichecheng` add column `appID` varchar(100) after `sjscfs`;

alter table `meicaiyang` add column `sjscfs` varchar(100) after `byzd10`;
alter table `meicaiyang` add column `appID` varchar(100) after `sjscfs`;

--alter table `pidaimeicaiyang` add column `sjscfs` varchar(100) after `byzd10`;
alter table `pidaimeicaiyang` add column `appID` varchar(100) after `byzd10`;

alter table `meizhi` add column `sjscfs` varchar(100) after `hydsl`;
alter table `meizhi` add column `appID` varchar(100) after `sjscfs`;

alter table `huayandan` add column `sjscfs` varchar(100) after `byzd5`;
alter table `huayandan` add column `appID` varchar(100) after `sjscfs`;

alter table `kjhuayandan` add column `appID` varchar(100) after `sjscfs`;
