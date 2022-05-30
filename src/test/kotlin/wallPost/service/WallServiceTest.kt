package wallPost.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import wallPost.OriginalPost

internal class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        // 1. Добавляем пост
        service.add(
            OriginalPost(
                ownerId = 1,
                text = "text1",
            )
        )
        service.add(
            OriginalPost(
                ownerId = 2,
                text = "text2",
            )
        )

        // Проверяем, что пост был отредактирован
        val posts = service.getPosts()

        assertEquals("text1", posts[0].text)
        assertEquals(1, posts[0].id)
        assertEquals(2, posts[1].id)
//        assertNotEquals(0,posts.get(0).id)
        for (originalPost: OriginalPost in service.getPosts()) {
            println(originalPost)
        }
        service.update(OriginalPost(id = 1, ownerId = 5, text = "text5", date = 1))
        assertEquals(1, posts[0].id)
        assertEquals(5, posts[0].ownerId)
        assertEquals("text5", posts[0].text)
        assertEquals(0, posts[0].date)

    }

    @Test
    fun update() {
        val service = WallService
        service.add(
            OriginalPost(
                ownerId = 1,
                text = "text1",
            )
        )
        service.add(
            OriginalPost(
                ownerId = 2,
                text = "text2",
            )
        )

        val update = OriginalPost(id = 2, ownerId = 22, text = "text22")
        val posts = service.getPosts()

        assertEquals(true, service.update(OriginalPost(id = 2, ownerId = 22, text = "text22")))
        assertEquals(true, service.update(OriginalPost(id = 1, ownerId = 1, text = "text1")))
        assertEquals(false, service.update(OriginalPost(id = 5, ownerId = 5, text = "text5")))
    }
}