package TDD_Test.course;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

	@Mock
	List<String> list;

	@Test
	public void primeiroTesteMockito() {
		Mockito.when(list.size()).thenReturn(20);

		list.size();
		list.add("");
		
		InOrder inOrder = Mockito.inOrder(list);
		inOrder.verify(list).size();
		inOrder.verify(list).add("");
	
	}
}
