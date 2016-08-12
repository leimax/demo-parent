import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Date;

public class MinaTestServer {

    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor();
//		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF8"))));
        acceptor.setHandler(new TimeServerHandler());
        acceptor.getSessionConfig()
                .setIdleTime(IdleStatus.BOTH_IDLE, 10);
        acceptor.bind(new InetSocketAddress(9123));

    }

}

class TimeServerHandler implements IoHandler {

    @Override
    public void exceptionCaught(IoSession arg0, Throwable arg1) throws Exception {
        System.out.println("TimeServerHandler.exceptionCaught()");

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("message read");
        System.out.println(message.toString());
        session.write(new Date());
        session.closeOnFlush();
    }

    @Override
    public void messageSent(IoSession arg0, Object arg1) throws Exception {
        System.out.println("TimeServerHandler.messageSent()");
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        System.out.println("TimeServerHandler.inputClosed()");
    }

    @Override
    public void sessionClosed(IoSession arg0) throws Exception {
        System.out.println("TimeServerHandler.sessionClosed()");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("TimeServerHandler.sessionCreated()");

    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("IoSession" + session.getIdleCount(status));
    }

    @Override
    public void sessionOpened(IoSession arg0) throws Exception {
        System.out.println("TimeServerHandler.sessionOpened()");

    }

}

