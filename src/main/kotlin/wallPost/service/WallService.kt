package wallPost.service

import wallPost.Comment
import wallPost.Post
import wallPost.PostNotFoundException
import wallPost.Report

object WallService {
    //    private val id = (1..5).random()

    private var globalid = 0
    private var originalPosts = emptyArray<Post>()

    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()

    fun add(originalPost: Post): Post {
        globalid++
        val copyPost = originalPost.copy(id = globalid)
        originalPosts = originalPosts.plus(copyPost)
        return originalPosts.last()
    }

    fun getPosts(): Array<Post> {
        return originalPosts;
    }

    fun checkText(checkOriginalPost: Post): String {
        for (originalPost: Post in getPosts()) {
            if (originalPost.id == checkOriginalPost.id && originalPost.text == null) {
                return "Text is null."
            }
        }
        return "Text presents."
    }

    fun update(updateOriginalPost: Post): Boolean {
        for (originalPost: Post in getPosts()) {
            if (originalPost.id == updateOriginalPost.id) {
                originalPost.text = updateOriginalPost.text
                originalPost.ownerId = updateOriginalPost.ownerId
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for (originalPost: Post in getPosts()) {
            if (postId == originalPost.id) {
                comments = comments.plus(comment)
                return comment
            }
        }
        throw PostNotFoundException()
    }

    fun getComments(): Array<Comment> {
        return comments
    }

    fun reportComment(commentId: Int, reason: Int) {
        // проверяем что параметры валидные
        // добавляем комментарий в массиов reports
        for (comment: Comment in getComments()) {
            if (comment.id == commentId && reason in 1..3) {
                reports = reports.plus(Report(commentId,reason))
                return
            }
        }
        throw PostNotFoundException()
    }

    fun getReports(): Array<Report> {
        return reports
    }
}