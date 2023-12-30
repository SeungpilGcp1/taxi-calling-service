<template>
    <v-card outlined>
        <v-card-title>
            StartRide
        </v-card-title>

        <v-card-text>
            <String label="RideId" v-model="value.rideId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="startRide"
            >
                StartRide
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
        name: 'StartRideCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.rideId = '';
        },
        watch: {
        },
        methods: {
            startRide() {
                this.$emit('startRide', this.value);
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

