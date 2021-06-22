package no.elhub.common.orchid.theme

import com.eden.orchid.api.registration.OrchidModule
import com.eden.orchid.api.theme.Theme
import com.eden.orchid.utilities.addToSet

class ElhubModule : OrchidModule() {

    override fun configure() {
        addToSet<Theme, ElhubTheme>()
    }
}
