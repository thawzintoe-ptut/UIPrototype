package com.ptut.uiprototype

import java.util.*

/**
 * Created by HeinHtetZaw on 5/20/21.
 */
data class SearchResultVO(
    val id: String = "",
    val carProfilePic: String = "",
    val carModel: String = "",
    val carNumberPlate: String = "",
    val seater: Int = 4,
    val rentalFee: Double = 0.0,
    val mileageFee: Double = 0.0,
    val distanceInKM: Double = 0.0
) {

    companion object{
        fun getTestData() = Collections.nCopies(20, SearchResultVO(
            "test-id","https://images.hgmsites.net/hug/2021-tesla-model-3_100777876_h.jpg","Tesla Model S","SMN7000B",4,30.00,0.40,0.5
        )
        )
    }
}