package nz.co.rroques.samy;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Handler implements RequestHandler {

    private static final Logger LOG = LogManager.getLogger(Handler.class);

    @Override
    public Object handleRequest(Object input, Context context) {
        LOG.error(input);
        LOG.error(context);
        return null;
    }
}
