/*import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class JsonNodeType implements UserType {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.OTHER }; // PostgreSQL의 JSONB 타입에 대응
    }

    @Override
    public Class<JsonNode> returnedClass() {
        return JsonNode.class; // 반환할 클래스
    }

    @Override
    public boolean equals(Object x, Object y) {
        return (x == y) || (x != null && y != null && x.equals(y));
    }

    @Override
    public int hashCode(Object x) {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
        JsonNode jsonNode = null;
        String jsonString = rs.getString(names[0]);
        if (jsonString != null) {
            try {
                jsonNode = objectMapper.readTree(jsonString);
            } catch (Exception e) {
                throw new RuntimeException("Failed to convert JSON string to JsonNode", e);
            }
        }
        return jsonNode;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
        } else {
            try {
                String jsonString = objectMapper.writeValueAsString(value);
                st.setObject(index, jsonString, Types.OTHER);
            } catch (Exception e) {
                throw new RuntimeException("Failed to convert JsonNode to JSON string", e);
            }
        }
    }

    @Override
    public Object deepCopy(Object value) {
        return value; // JsonNode는 불변이므로 원래 객체를 반환
    }

    @Override
    public boolean isMutable() {
        return false; // JsonNode는 불변 객체
    }

    @Override
    public Serializable disassemble(Object value) {
        return (Serializable) value; // 객체를 Serializable로 반환
    }

    @Override
    public Object assemble(Serializable cached, Object owner) {
        return cached; // Serializable에서 객체로 복원
    }

    @Override
    public Object replace(Object original, Object target, Object owner) {
        return original; // 원래 객체를 반환
    }
}
*/