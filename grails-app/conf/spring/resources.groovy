import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.factory.HttpClientFactory
import com.popcornteam.restclient.header.ContentType
import com.popcornteam.restclient.header.HttpHeader

beans = {

    razerClient(
            RestClient,
            application.config.stats.api.endpoint,
            [
                    new HttpHeader('Accept', ContentType.APPLICATION_JSON),
                    new HttpHeader('Content-Type', ContentType.APPLICATION_JSON)
            ],
            new HttpClientFactory().makeThreadSafeHttpClient(32)
    )

}
