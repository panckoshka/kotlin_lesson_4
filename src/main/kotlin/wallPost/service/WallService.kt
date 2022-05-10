package wallPost.service

import wallPost.Post

object WallService {
    //    private val id = (1..5).random()
    private var globalid = 0
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        globalid++
        val copyPost = post.copy(id = globalid)
        posts = posts.plus(copyPost)
        return posts.last()
    }

    fun getPosts(): Array<Post> {
        return posts;
    }

    fun update(updatePost: Post): Boolean {
        for (post: Post in getPosts()) {
            if (post.id == updatePost.id) {
                post.text = updatePost.text
                post.ownerId = updatePost.ownerId
                return true
            }
        }
        return false
    }

}