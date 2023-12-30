<template>
    <v-card outlined>
        <v-card-title>
            ReceiveReview
        </v-card-title>

        <v-card-text>
            <String label="RideId" v-model="value.rideId" :editMode="editMode"/>
            <Rating offline label="Rating" v-model="value.rating" :editMode="editMode" @change="change"/>
            <Comment offline label="Comment" v-model="value.comment" :editMode="editMode" @change="change"/>
            <Comment offline label="Comment" v-model="value.comment" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="receiveReview"
            >
                ReceiveReview
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ReceiveReviewCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.rideId = '';
            this.value.rating = {};
            this.value.comment = {};
        },
        watch: {
        },
        methods: {
            receiveReview() {
                this.$emit('receiveReview', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

