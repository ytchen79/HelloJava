package cyt.utils;

/**
 * @Description: TODO
 * @Function List: TODO
 * @author: ytchen
 * www.abc.com是一个视频点播网站，Arbergo是一个基础存储系统，它为该视频网站提供了基础服务描述如下：
该系统存储了全部需要下载的文件，并提供JAVA接口用于视频文件下载
接口允许指定1到n个文件名下载多个文件
接口返回的文件内容支持分片，例如file.part1， file.part2
接口定义时需考虑到异常情况
接口支持按照指定文件区间下载，例如，下载file1的第101个字节到文件末尾，下载file2的第1个字节到第100个字节。
该系统实现了基于SATA硬盘和SSD硬盘的混合存储。混合存储的特点是SATA硬盘的存储空间更大，但访问速度更慢，SSD硬盘存储空间较小，但访问速度更快。文件在两种磁盘类型中可以迁移。

问题1：请用Java语言完成该系统中描述的对外提供的接口定义，并用注释说明该接口各个参数的含义以及取值范围。
问题2：针对Arbergo系统在#6中描述的混合存储特点，请用文字描述该系统的设计思路。设计思路可以包括但不限于文件在磁盘中的分布，文件在不同磁盘类型中的迁移规则，访问规则。
 * @Date: 2016/9/9
 */
public interface FileDownload {
    /**
     * 指定1到n个文件名下载多个文件
     * @param filePath
     */
    void downMulFiles(String[] filePath) throws Exception;

    /**
     *
     * @param filePath
     * @param index
     */
    void downFileSegment(String filePath, int index);
}
