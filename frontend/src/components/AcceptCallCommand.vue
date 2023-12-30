<template>
    <v-card outlined>
        <v-card-title>
            AcceptCall
        </v-card-title>

        <v-card-text>
            <String label="DriverId" v-model="value.driverId" :editMode="editMode"/>
            <String label="TaxiCallId" v-model="value.taxiCallId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="acceptCall"
            >
                AcceptCall
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
        name: 'AcceptCallCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.driverId = '';
            this.value.taxiCallId = '';
        },
        watch: {
        },
        methods: {
            acceptCall() {
                this.$emit('acceptCall', this.value);
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

