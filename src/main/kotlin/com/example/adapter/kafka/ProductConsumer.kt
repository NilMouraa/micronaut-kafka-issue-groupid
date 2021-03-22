package com.example.adapter.kafka

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(
    offsetReset = OffsetReset.EARLIEST,
    groupId = "MY_GROUP_ID"
)
class ProductConsumer {
    @Topic("my-products")
    fun receive(@KafkaKey brand: String, product: Product) {
        println("Got Product - ${product.name} by $brand")
    }
}

data class Product(var name: String)