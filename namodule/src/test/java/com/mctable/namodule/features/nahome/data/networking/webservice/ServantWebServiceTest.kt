package com.mctable.namodule.features.nahome.data.networking.webservice

import com.mctable.core.utils.extensions.enqueueRequest
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.data.response.SkillResponse
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class ServantWebServiceTest {

    private val server = MockWebServer()
    private lateinit var webService: ServantHomeWebService
    private val servantResponse: List<ServantResponse> = listOf(
        ServantResponse(
            id = 100100,
            name = "Altria Pendragon",
            classId = 1,
            className = "saber",
            attribute = "earth",
            rarity = 5,
            atkMax = 11221,
            hpMax = 15150,
            gender = "female",
            cards = listOf(
                "quick",
                "arts",
                "arts",
                "buster",
                "buster"
            ),
            skills = listOf(
                SkillResponse(
                    id = 5450,
                    num = 1,
                    name = "Charisma B",
                    detail = "Increase all allies' ATK (3 turns)",
                    icon = "https://static.atlasacademy.io/NA/SkillIcons/skill_00300.png",
                    coolDowns = listOf(
                        7,
                        7,
                        7,
                        7,
                        7,
                        6,
                        6,
                        6,
                        6,
                        5
                    )
                )
            ),
        )
    )

    @Before
    fun setup() {
        webService = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServantHomeWebService::class.java)
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @Test
    fun should_return_a_servant_list_response_when_get_servants_is_successful() = runTest {
        server.enqueueRequest("responses/servants_list_200_response.json", 200)

        val result = webService.getServants(0, 1)

        Assert.assertEquals(servantResponse, result.body())
        Assert.assertEquals(200, result.code())

    }

}