package com.mctable.namodule.features.nahome.data.networking.mapper

import com.mctable.core.utils.interfaces.Mapper
import com.mctable.namodule.features.nahome.data.response.ServantResponse
import com.mctable.namodule.features.nahome.domain.model.ServantModel
import com.mctable.namodule.features.nahome.mockers.servantResponse
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
        val response = mapper.transform(servantResponse)

        // Assert
        Assert.assertEquals(response.size, servantResponse.size)
        Assert.assertEquals(response[0].name, servantResponse[0].name)
        Assert.assertEquals(response[0].atkMax, servantResponse[0].atkMax)
        Assert.assertEquals(response[0].attribute, servantResponse[0].attribute)
        Assert.assertEquals(response[0].cards, servantResponse[0].cards)
        Assert.assertEquals(response[0].gender, servantResponse[0].gender)
        Assert.assertEquals(response[0].classId, servantResponse[0].classId)
        Assert.assertEquals(response[0].className, servantResponse[0].className)
        Assert.assertEquals(response[0].rarity, servantResponse[0].rarity)
        Assert.assertEquals(response[0].hpMax, servantResponse[0].hpMax)

    }
}