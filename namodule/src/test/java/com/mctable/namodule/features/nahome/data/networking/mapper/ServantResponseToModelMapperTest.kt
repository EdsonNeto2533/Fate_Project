package com.mctable.namodule.features.nahome.data.networking.mapper

import com.mctable.commons.ds.utils.ServantCard
import com.mctable.core.utils.interfaces.Mapper
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.mockers.servantListResponse
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ServantResponseToModelMapperTest {

    private lateinit var mapper: Mapper<List<ServantResponse>, List<ServantModel>>

    @Before
    fun setup() {
        mapper = ServantResponseToModelMapper()
    }

    @Test
    fun should_map_the_correct_data_when_transform_is_called() {
        // Act
        val response = mapper.transform(servantListResponse)

        // Assert
        Assert.assertEquals(response.size, servantListResponse.size)
        Assert.assertEquals(response[0].name, servantListResponse[0].name)
        Assert.assertEquals(response[0].atkMax, servantListResponse[0].atkMax)
        Assert.assertEquals(response[0].attribute, servantListResponse[0].attribute)
        response[0].cards.forEachIndexed { index, servantCard ->
            Assert.assertEquals(servantCard.key, servantListResponse[0].cards[index])
        }
        Assert.assertEquals(response[0].gender, servantListResponse[0].gender)
        Assert.assertEquals(response[0].classId, servantListResponse[0].classId)
        Assert.assertEquals(response[0].className, servantListResponse[0].className)
        Assert.assertEquals(response[0].rarity, servantListResponse[0].rarity)
        Assert.assertEquals(response[0].hpMax, servantListResponse[0].hpMax)

    }

    @Test
    fun should_return_arts_when_the_card_is_unknown() {
        // Arrange
        val servantMock: ServantResponse = mockk(relaxed = true)
        val servantListMock: List<ServantResponse> = listOf(
            servantMock
        )
        every { servantMock.cards } returns listOf("mock")

        // Act
        val response = mapper.transform(servantListMock)

        // Assert
        Assert.assertEquals(ServantCard.ARTS.key, response.first().cards.first().key)

    }
}