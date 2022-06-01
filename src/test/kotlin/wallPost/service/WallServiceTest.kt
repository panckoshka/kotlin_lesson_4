package wallPost.service

//import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import wallPost.Comment
import wallPost.Post
import wallPost.PostNotFoundException
import kotlin.test.assertFailsWith
import kotlin.test.Test

internal class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        // 1. Добавляем пост
        service.add(
            Post(
                ownerId = 1,
                text = "text1",
            )
        )
        service.add(
            Post(
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
        for (originalPost: Post in service.getPosts()) {
            println(originalPost)
        }
        service.update(Post(id = 1, ownerId = 5, text = "text5", date = 1))
        assertEquals(1, posts[0].id)
        assertEquals(5, posts[0].ownerId)
        assertEquals("text5", posts[0].text)
        assertEquals(0, posts[0].date)
    }

    @Test
    fun update() {
        val service = WallService
        service.add(
            Post(
                ownerId = 1,
                text = "text1",
            )
        )
        service.add(
            Post(
                ownerId = 2,
                text = "text2",
            )
        )
        val update = Post(id = 2, ownerId = 22, text = "text22")
        val posts = service.getPosts()

        assertEquals(true, service.update(Post(id = 2, ownerId = 22, text = "text22")))
        assertEquals(true, service.update(Post(id = 1, ownerId = 1, text = "text1")))
        assertEquals(false, service.update(Post(id = 5, ownerId = 5, text = "text5")))
    }

    @Test
    fun createComment() {
        val service = WallService
        // 1. Добавляем пост
        service.add(
            Post(
                ownerId = 1,
                text = "text1",
            )
        )
        service.add(
            Post(
                ownerId = 2,
                text = "text2",
            )
        )

        service.createComment(1, Comment(1, "qqq"))

        assertFailsWith<PostNotFoundException> {
            service.createComment(22, Comment(1, "fff"))
        }
        val comments = service.getComments()

        assertEquals(1, comments.size)
        assertEquals("qqq", comments[0].text)
    }
// не работает => expected
//    @Test(expected = PostNotFoundException::class)
//    fun shouldThrow() {
//        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
//        val service = WallService
//
//        service.createComment(1, Comment(100, "text"))
//    }

    @Test
    fun reportComment() {
        val service = WallService
        // 1. Добавляем пост
        service.add(
            Post(
                ownerId = 1,
                text = "text1",
            )
        )
        service.add(
            Post(
                ownerId = 2,
                text = "text2",
            )
        )
        service.createComment(1, Comment(1, "qqq"))
        service.reportComment(1, 1)
        assertEquals(1, service.getReports().size)

        assertFailsWith<PostNotFoundException> {
            service.reportComment(1, 5)
        }
    }
}