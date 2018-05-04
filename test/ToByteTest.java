import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.stream.Collectors;

public final class ToByteTest {

    @Test
    public final void separateVertexAndNormals() throws IOException {
        new BufferedWriter(new FileWriter(new File("src/n.txt")))
                .write(new BufferedReader(new FileReader(new File("src/head_result.buf")))
                        .lines().collect(Collectors.toList()).get(0));
    }

    @Test
    public final void convertToByte() throws IOException {
        final List<String> list = new BufferedReader(new FileReader(new File("src/n.txt")))
                .lines().collect(Collectors.toList());
        final String[] strings = list.get(0).split(" ");
        final ByteBuffer byteBuffer = ByteBuffer.allocate(strings.length * 4);
        for (final String str :strings) {
            byteBuffer.putFloat(Float.parseFloat(str));
        }
        FileUtils.writeByteArrayToFile(new File("src/nByte.bytes"), byteBuffer.array());
    }
}