package cn.liuyiyou.shop;

import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.imageio.ImageIO;
import javax.sql.DataSource;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/31
 * @version: V1.0
 */
public class DownloadImg {

    static final String URL = "jdbc:mysql://127.0.0.1:3306/test";

    private DataSource dataSource;

    @Test
    public void getLisConnection() throws SQLException {
        DataSource dataSource = new SimpleDriverDataSource(BeanUtils.instantiateClass(com.mysql.jdbc.Driver.class), URL,
                "root", "123456");
        QueryRunner query = new QueryRunner(dataSource);
        List<String> tablesNames = query.query("show tables", new ResultSetHandler<List<String>>() {
            List<String> tables = Lists.newArrayList();

            @Override
            public List<String> handle(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    tables.add(rs.getString(1));
                }
                return tables;
            }
        });
        for (String name : tablesNames) {
            System.out.println(name);
        }
    }


    public void init() {
    }


    @Test
    public void getImgInfomation() throws IOException {
        File file = new File("D:/", "4897076840366.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        long length = file.length();
        System.out.println(width + "__" + height + "__" + length / 1024);
    }

    @Test
    public void test() throws MalformedURLException {
        Img from = Img.from(new URL("http://img.liuyiyou.cn/resource/10239T91/20190725/4897076840366.png"));
        BufferedImage bufferedImage = ImgUtil.toBufferedImage(from.getImg());
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        File file = FileUtil.file("e:/face_radis.png");
        long length = file.length();
        System.out.println(width + "__" + height + "__" + length / 1024);
        from.write(file);
    }

    @Test
    public void downloadImgFromUrl() throws IOException {
        String url = "http://img.liuyiyou.cn/resource/10239T91/20190725/4897076840366.png";
        String[] split = url.split("\\/");
        String fileName = split[split.length - 1];
        InputStream inputStream =
                getInputStreamByGet(url);
        File file = new File("D:/", fileName);

        saveData(inputStream, file);
    }

    // 通过get请求得到读取器响应数据的数据流
    public static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                    .openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveData(InputStream is, File file) {
        try (BufferedInputStream bis = new BufferedInputStream(is);
             BufferedOutputStream bos = new BufferedOutputStream(
                     new FileOutputStream(file))) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
